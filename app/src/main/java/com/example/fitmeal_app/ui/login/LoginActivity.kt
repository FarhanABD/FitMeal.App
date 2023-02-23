package com.example.fitmeal_app.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.fitmeal_app.databinding.ActivityLoginBinding
import com.example.fitmeal_app.network.ApiClient

class LoginActivity : AppCompatActivity(), LoginView{

    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }
    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        presenter = LoginPresenter(this, ApiClient.getService())

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
        when (response.status){
            true -> {
                Toast.makeText(applicationContext, response.msg, Toast.LENGTH_SHORT).show()
            }
            false ->{

            }
        }
    }

    override fun loginError(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}