package com.example.fitmeal_app.ui.login

import com.example.fitmeal_app.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginPresenter (
    private val view: LoginView,
    private val api: ApiService,
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
}
interface  LoginView {
    fun setupListener()
    fun loginLoading(loading: Boolean)
    fun loginResponse(response: LoginResponse)
    fun loginError(message: String)
}