package com.bizyback.play.recipe.datasources.remote.api

import com.bizyback.play.recipe.datasources.remote.dto.RecipeSearchResponseDTO
import com.bizyback.play.recipe.datasources.remote.helpers.NetworkResult

/**
 * @project : Recipe
 * @author  : mambo
 * @email   : mambobryan@gmail.com
 * @date    : Sun 31 December 2023
 * @time    : 11:25 am
 */
interface RecipeSearchApi {

    suspend fun fetchSearchedRecipes(
        type: String = "public",
        query: String
    ): NetworkResult<RecipeSearchResponseDTO>

}