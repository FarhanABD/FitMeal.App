package com.example.fitmeal_app.ui.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.fitmeal_app.ui.BaseActivity
import com.example.fitmeal_app.ui.home.HomeActivity
import com.example.fitmeal_app.ui.login.LoginActivity
import com.example.fitmeal_app.R

class SplashActivity : BaseActivity(), SplashView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        SplashPresenter(this)

    }

    override fun nextPage(isLogin: Int) {
        //------- FUNGSI TIMER SPLASH SCREEN --------------------//
        Handler(Looper.myLooper()!!).postDelayed({
            if(isLogin == 1) startActivity(Intent(this, HomeActivity::class.java))
            else startActivity(Intent( this, LoginActivity:: class.java))
            finish()
        }, 2000)
    }
}