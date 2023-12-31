package com.bizyback.play.recipe.data.domain.repositories

import com.bizyback.play.recipe.data.domain.models.DataResult
import com.bizyback.play.recipe.data.domain.models.Recipe
import com.bizyback.play.recipe.data.domain.models.RecipeType

/**
 * @project : Recipe
 * @author  : mambo
 * @email   : mambobryan@gmail.com
 * @date    : Sun 31 December 2023
 * @time    : 1:30 pm
 */
interface RecipeRepository {

    suspend fun searchRecipes(
        type: RecipeType = RecipeType.PUBLIC,
        query: String
    ): DataResult<List<Recipe>>

}