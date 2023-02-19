package com.example.fitmeal_app.ui.login

data class LoginResponse (
    val status: Boolean,
    val msg: String,
    val data:LoginData?
    )

data class LoginData (
    val email: String,
    val password: String,
    val name: String,
    val gender: String,
    val phone: String,
    val avatar: String,

    )