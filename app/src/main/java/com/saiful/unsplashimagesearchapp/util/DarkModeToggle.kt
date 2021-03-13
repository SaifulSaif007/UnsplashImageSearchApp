package com.saiful.unsplashimagesearchapp.util

import androidx.appcompat.app.AppCompatDelegate

object DarkModeToggle {

    fun toggleDarkMode(){
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
    }
}