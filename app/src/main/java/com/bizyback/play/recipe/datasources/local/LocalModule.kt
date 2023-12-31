package com.bizyback.play.recipe.datasources.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.preferencesOf
import androidx.datastore.preferences.preferencesDataStore
import com.bizyback.play.recipe.datasources.local.preferences.LocalPreferences
import com.bizyback.play.recipe.datasources.local.preferences.LocalPreferencesImpl
import com.bizyback.play.recipe.datasources.local.preferences.UserPreferences
import com.bizyback.play.recipe.datasources.local.preferences.UserPreferencesImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

/**
 * @project : Recipe
 * @author  : mambo
 * @email   : mambobryan@gmail.com
 * @date    : Sun 31 December 2023
 * @time    : 6:08 pm
 */

@Module
@InstallIn(SingletonComponent::class)
class LocalModule {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

    @Provides
    fun providesDataStore(@ApplicationContext context: Context) = context.dataStore

    @Provides
    fun providesLocalPreferences(dataStore: DataStore<Preferences>): LocalPreferences =
        LocalPreferencesImpl(dataStore = dataStore)

    @Provides
    fun providesUserPreferences(dataStore: DataStore<Preferences>): UserPreferences =
        UserPreferencesImpl(dataStore = dataStore)

}