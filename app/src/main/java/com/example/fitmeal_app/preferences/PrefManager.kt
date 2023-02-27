package com.example.fitmeal_app.preferences

import android.content.Context
import android.content.SharedPreferences

class PrefManager (context: Context) {
    private val prefName = "kelasOnline12345.pref"
    private val sharedPref: SharedPreferences
    private val editor: SharedPreferences.Editor

    init {
        sharedPref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
        editor = sharedPref.edit()
    }

    //--------- UNTUK NYIMPEN DATANYA MENGGUNAKAN SHARED PREFERENCES -----------------------------//
    fun put(key: String, value: String){
        editor.putString(key, value).apply()
    }
    fun put(key: String, value: Int){
        editor.putInt(key, value).apply()
    }

    //------- UNTUK MENDAPATKAN DATA MENGGUNAKAN SHARED PREF --------------------------------------//
    fun getString(key: String): String? {
        return sharedPref.getString(key,"")
    }

    fun getInt(key: String): Int{
        return sharedPref.getInt(key,0)

    }

    //-------------- UNTUK MENGHAPUS SESSION SAAT LOGOUT -----------------------------------------//
    fun clear(){
        editor.clear().apply()
    }


}