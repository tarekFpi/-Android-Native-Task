package com.example.mytmv.di

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class TokenManager @Inject constructor(@ApplicationContext context: Context) {
    private var prefs: SharedPreferences =
        context.getSharedPreferences("PREFS_TOKEN_FILE", Context.MODE_PRIVATE)

    fun saveToken(token: String) {
        val editor = prefs.edit()
        editor.putString("Token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJVc2VySWQiOiI3OCIsIkN1cnJlbnRDb21JZCI6IjEiLCJuYmYiOjE2ODEyMDcxNDQsImV4cCI6MTY4MTgxMTk0NCwiaWF0IjoxNjgxMjA3MTQ0fQ.UWdxlq2vEB4IDn4XlfWQh5fx27E7IyiFijlBgqO-bO0")
        editor.apply()
    }

    fun getToken(): String? {
        return prefs.getString("Token", null)
    }
}