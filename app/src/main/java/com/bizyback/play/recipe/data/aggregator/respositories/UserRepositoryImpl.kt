package com.bizyback.play.recipe.data.aggregator.respositories

import com.bizyback.play.recipe.data.domain.repositories.UserRepository
import com.bizyback.play.recipe.datasources.local.preferences.LocalPreferences
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @project : Recipe
 * @author  : mambo
 * @email   : mambobryan@gmail.com
 * @date    : Sun 31 December 2023
 * @time    : 6:42 pm
 */
class UserRepositoryImpl @Inject constructor(
    private val localPreferences: LocalPreferences
) : UserRepository {

    override val isDarkModeEnabled: Flow<Boolean>
        get() = localPreferences.isDarkModeEnabled

    override suspend fun updateDarkModeTheme() {
        localPreferences.updateDarkMode()
    }
}