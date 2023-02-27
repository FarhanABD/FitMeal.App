package com.example.fitmeal_app.ui.login

import com.example.fitmeal_app.network.ApiService
import com.example.fitmeal_app.preferences.PrefManager
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginPresenter (
    private val view: LoginView,
    private val api: ApiService,
    private val pref: PrefManager,
        ) {

    init {
        view.setupListener()
    }
    fun fetchLogin(email: String, password: String)
    {
        view.loginLoading(loading = true)
        GlobalScope.launch { val response = api.login(email , password)
        if (response.isSuccessful)
        {
            withContext(Dispatchers.Main)
            {
                view.loginResponse(response.body()!!)
                view.loginLoading(loading = false)
            }
        } else {
            view.loginError("Login Error")
               }
        }
    }
    //-------------- MENYIMPAN INFORMASI USER UNTUK DITAMPILKAN -----------------//
    fun saveLogin(data: LoginData){
        pref.put("is_login",1)
        pref.put("user_login",Gson().toJson(data))
    }
}
interface  LoginView {
    fun setupListener()
    fun loginLoading(loading: Boolean)
    fun loginResponse(response: LoginResponse)
    fun loginError(message: String)
}