package com.example.fitmeal_app.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fitmeal_app.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), LoginView{

    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView()

    }
}