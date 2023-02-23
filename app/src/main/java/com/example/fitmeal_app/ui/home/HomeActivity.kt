package com.example.fitmeal_app.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.fitmeal_app.R
import com.example.fitmeal_app.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity(){

    private val binding by lazy { ActivityHomeBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.navView.setupWithNavController(
            findNavController(R.id.nav_host_fragment)
        )
    }

}