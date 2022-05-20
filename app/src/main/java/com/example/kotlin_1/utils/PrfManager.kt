package com.example.kotlin_1.utils

import android.content.Context

class PrfManager(context: Context) {

    private val sharedPreferences = context.getSharedPreferences("PREFRANCE_NAME", 0)


    fun savePrefString(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun getPrefString(key: String): String? {
        return sharedPreferences.getString(key, null)

    }

    fun saveprefInt(key: String, value: Int) {
        sharedPreferences.edit().putInt(key, value).apply()
    }


    fun getPrefInt(key: String): Int? {
        return sharedPreferences.getInt(key, 0)
    }
}