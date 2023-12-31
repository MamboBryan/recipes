package com.bizyback.play.recipe.data.domain.repositories

import com.bizyback.play.recipe.data.domain.models.DataResult
import com.bizyback.play.recipe.data.domain.models.Recipe
import com.bizyback.play.recipe.data.domain.models.RecipeType
import kotlinx.coroutines.flow.Flow

/**
 * @project : Recipe
 * @author  : mambo
 * @email   : mambobryan@gmail.com
 * @date    : Sun 31 December 2023
 * @time    : 1:30 pm
 */
interface RecipeRepository {

    val searchedWords: Flow<List<String>>

    suspend fun searchRecipes(
        type: RecipeType = RecipeType.PUBLIC,
        query: String
    ): DataResult<List<Recipe>>

}