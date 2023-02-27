package com.example.fitmeal_app.ui.profile

import com.example.fitmeal_app.preferences.PrefManager
import android.util.Log
import com.example.fitmeal_app.ui.login.LoginData
import com.google.gson.Gson

class ProfilePresenter(
    private val view: ProfileView,
    private val pref: PrefManager,
    ) {

    init {
        view.user(user())
    }

    //------ MEMANGGIL DATA USER UNTUK KE HALAMAN PROFILE ----------//
//    fun name(): String{
//        return pref.getString("user_name")!!
//    }

    private fun user(): LoginData{
        val json = pref.getString("user_login")
        return Gson().fromJson(json, LoginData::class.java)
    }

    fun logout(){
        pref.clear()
        view.logout()
    }
}

interface ProfileView{
    fun logout()
    fun user(user:LoginData)
    fun setupListener()
}