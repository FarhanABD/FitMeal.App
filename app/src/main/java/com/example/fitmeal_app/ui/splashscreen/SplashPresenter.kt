package com.example.fitmeal_app.ui.splashscreen

import com.example.fitmeal_app.preferences.PrefManager

class SplashPresenter (
    private val view: SplashView,
    private val pref: PrefManager,
) {
    init {
        view.nextPage(pref.getInt("is_login"))
    }
}
interface SplashView {
    fun nextPage(isLogin: Int)
}