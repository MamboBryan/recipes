package com.bizyback.play.recipe.datasources.local.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapLatest
import javax.inject.Inject

/**
 * @project : Recipe
 * @author  : mambo
 * @email   : mambobryan@gmail.com
 * @date    : Sun 31 December 2023
 * @time    : 5:40 pm
 */
class LocalPreferencesImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : LocalPreferences {

    data object Keys {
        val darkMode = booleanPreferencesKey("DARK_MODE")
    }

    override val isDarkModeEnabled: Flow<Boolean>
        get() = dataStore.data.mapLatest { it[Keys.darkMode] ?: false }

    override suspend fun updateDarkMode() {
        val isEnabled = dataStore.data.map { it[Keys.darkMode] }.firstOrNull() ?: false
        dataStore.edit {
            it[Keys.darkMode] = !isEnabled
        }
    }

}