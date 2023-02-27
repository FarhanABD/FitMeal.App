package com.example.fitmeal_app.ui.login

import RegisterActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.Toast
import com.example.fitmeal_app.R
import com.example.fitmeal_app.databinding.ActivityLoginBinding
import com.example.fitmeal_app.network.ApiClient
import com.example.fitmeal_app.preferences.PrefManager
import com.example.fitmeal_app.ui.home.HomeActivity


class LoginActivity : AppCompatActivity(), LoginView{

    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }
    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        presenter = LoginPresenter(this,
            ApiClient.getService(),
            PrefManager(this)

        )

        val button = findViewById<Button>(R.id.button_register)
        button.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    class RegisterActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_register)
        }
    }


    override fun setupListener() {

        binding.editEmail.setText("taufik@gmail.com")
        binding.editPassword.setText("taufik@gmail.com")

        binding.buttonLogin.setOnClickListener{
            presenter.fetchLogin(
                binding.editEmail.text.toString(),
                binding.editPassword.text.toString(),
            )
        }
    }

    override fun loginLoading(loading: Boolean) {
        binding.buttonLogin.isEnabled = loading.not()
        when(loading){
            true -> binding.buttonLogin.text = "Tunggu.."
            false -> binding.buttonLogin.text = "Masuk"
        }
    }

    override fun loginResponse(response: LoginResponse) {
        Toast.makeText(applicationContext, response.msg, Toast.LENGTH_SHORT).show()
        when (response.status){
            true -> {
                presenter.saveLogin(response.data!!)
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            }
            false ->{

            }
        }
    }

    override fun loginError(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }


}
