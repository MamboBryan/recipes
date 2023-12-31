package com.bizyback.play.recipe.features.recipesearch

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.hilt.ScreenModelKey
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.multibindings.IntoMap

/**
 * @project : Recipe
 * @author  : mambo
 * @email   : mambobryan@gmail.com
 * @date    : Sun 31 December 2023
 * @time    : 3:35 pm
 */
@Module
@InstallIn(ActivityComponent::class)
abstract class ScreenModule {

    @Binds
    @IntoMap
    @ScreenModelKey(RecipeSearchModel::class)
    abstract fun bindsRecipeScreenModel(screenModel: RecipeSearchModel): ScreenModel

}