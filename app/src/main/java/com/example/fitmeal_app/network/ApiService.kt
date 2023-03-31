package com.example.fitmeal_app.network

import com.example.fitmeal_app.ui.login.LoginResponse
import com.example.fitmeal_app.ui.resep.CategoryResponse
import com.example.fitmeal_app.ui.resep.CourseResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @POST("api/login")
    suspend fun login(
        @Query("email") email: String,
        @Query("password") password: String,
    ) : Response<LoginResponse>

    //----- API UNTUK MEMANGGIL CATEGORY DARI DATABASE ----------//
    @GET("api/category")
    suspend fun category() : Response<CategoryResponse>

    //---------- API UNTUK MEMANGGIL COURSE/ RESEP DARI DATABASE ---------//
    @GET("api/course")
    suspend fun  course (
        @Query("Keyword") Keyword: String,
    ) : Response<CourseResponse>


}