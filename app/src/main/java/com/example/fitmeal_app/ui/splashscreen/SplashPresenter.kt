package com.example.fitmeal_app.ui.splashscreen

class SplashPresenter (
    private val view: SplashView
) {
    init {
        view.nextPage(isLogin = 1)
    }
}
interface SplashView {
    fun nextPage(isLogin: Int)
}