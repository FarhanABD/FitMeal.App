import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fitmeal_app.R
import com.example.fitmeal_app.databinding.ActivityHomeBinding
import com.example.fitmeal_app.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private val binding by lazy {ActivityRegisterBinding.inflate(layoutInflater) }

    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etName = findViewById(R.id.et_name)
        etEmail = findViewById(R.id.et_email)
        etPassword = findViewById(R.id.et_password)
    }

    fun onRegisterClick(view: android.view.View) {
        val name = etName.text.toString()
        val email = etEmail.text.toString()
        val password = etPassword.text.toString()


        Toast.makeText(this, "Thank you for registering!", Toast.LENGTH_SHORT).show()
    }
}
