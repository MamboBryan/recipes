package com.bizyback.play.recipe.data.aggregator.di

import com.bizyback.play.recipe.data.aggregator.respositories.RecipeRepositoryImpl
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
    fun providesRecipeRepository(api: RecipeSearchApi) = RecipeRepositoryImpl(remoteSource = api)

}