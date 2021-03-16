package com.saiful.unsplashimagesearchapp.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.saiful.unsplashimagesearchapp.data.repository.DataStoreRepository.PreferenceKeys.darkModeStatus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton


const val PREFERENCE_NAME = "settings"

@Singleton
class DataStoreRepository @Inject constructor(context: Context) {

    private object PreferenceKeys {

        val darkModeStatus = booleanPreferencesKey("darkMode")

    }

    private val Context.dataStore : DataStore<Preferences> by preferencesDataStore(
        name = PREFERENCE_NAME
    )

    suspend fun saveDarkMode(status: Boolean, context: Context){
        context.dataStore.edit { settings ->
            settings[darkModeStatus] = status
        }
    }

    val readDarkModeStatus :  Flow<Boolean> = context.dataStore.data.map { settings->
        settings[darkModeStatus] ?: false
    }


}