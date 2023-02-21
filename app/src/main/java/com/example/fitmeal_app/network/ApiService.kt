package com.example.fitmeal_app.network

import com.example.fitmeal_app.ui.login.LoginResponse
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("api/login")
    suspend fun login(
        @Query("email") email: String,
        @Query("password") password: String,
    ) : Response<LoginResponse>
}