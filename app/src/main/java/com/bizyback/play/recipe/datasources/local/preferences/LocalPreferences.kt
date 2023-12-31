package com.bizyback.play.recipe.datasources.local.preferences

import kotlinx.coroutines.flow.Flow

/**
 * @project : Recipe
 * @author  : mambo
 * @email   : mambobryan@gmail.com
 * @date    : Sun 31 December 2023
 * @time    : 5:38 pm
 */
interface LocalPreferences {

    val isDarkModeEnabled: Flow<Boolean>

    suspend fun updateDarkMode()

}