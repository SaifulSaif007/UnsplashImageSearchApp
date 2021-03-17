package com.saiful.unsplashimagesearchapp.util

import androidx.appcompat.app.AppCompatDelegate

object DarkModeToggle {

    fun toggleDarkMode(status: Boolean) {
        if (status) AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}