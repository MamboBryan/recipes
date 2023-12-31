package com.bizyback.play.recipe.data.domain.repositories

import kotlinx.coroutines.flow.Flow

/**
 * @project : Recipe
 * @author  : mambo
 * @email   : mambobryan@gmail.com
 * @date    : Sun 31 December 2023
 * @time    : 6:41 pm
 */
interface UserRepository {

    val isDarkModeEnabled: Flow<Boolean>

    suspend fun updateDarkModeTheme()

}