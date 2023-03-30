package com.example.fitmeal_app.ui.resep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fitmeal_app.R
import com.example.fitmeal_app.databinding.ActivityResepBinding

class ResepActivity : AppCompatActivity() {
    private val binding by lazy { ActivityResepBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resep)
        setContentView(binding.root)
    }
}