package com.bizyback.play.recipe.data.aggregator.di

import com.bizyback.play.recipe.data.aggregator.respositories.RecipeRepositoryImpl
import com.bizyback.play.recipe.data.aggregator.respositories.UserRepositoryImpl
import com.bizyback.play.recipe.data.domain.repositories.RecipeRepository
import com.bizyback.play.recipe.data.domain.repositories.UserRepository
import com.bizyback.play.recipe.datasources.local.preferences.LocalPreferences
import com.bizyback.play.recipe.datasources.local.preferences.UserPreferences
import com.bizyback.play.recipe.datasources.remote.api.RecipeSearchApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * @project : Recipe
 * @author  : mambo
 * @email   : mambobryan@gmail.com
 * @date    : Sun 31 December 2023
 * @time    : 2:24 pm
 */

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun providesRecipeRepository(
        api: RecipeSearchApi,
        userPreferences: UserPreferences
    ): RecipeRepository =
        RecipeRepositoryImpl(remoteSource = api, userPreferences = userPreferences)

    @Provides
    fun providesUserRepository(
        localPreferences: LocalPreferences
    ): UserRepository =
        UserRepositoryImpl(localPreferences = localPreferences)

}