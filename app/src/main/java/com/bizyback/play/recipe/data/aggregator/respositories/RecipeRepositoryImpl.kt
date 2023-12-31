package com.bizyback.play.recipe.data.aggregator.respositories

import com.bizyback.play.recipe.data.aggregator.mappers.toDomain
import com.bizyback.play.recipe.data.domain.models.DataResult
import com.bizyback.play.recipe.data.domain.models.Recipe
import com.bizyback.play.recipe.data.domain.models.RecipeType
import com.bizyback.play.recipe.data.domain.repositories.RecipeRepository
import com.bizyback.play.recipe.datasources.remote.api.RecipeSearchApi
import com.bizyback.play.recipe.datasources.remote.dto.RecipeDetailsDTO
import com.bizyback.play.recipe.datasources.remote.helpers.NetworkResult
import javax.inject.Inject

/**
 * @project : Recipe
 * @author  : mambo
 * @email   : mambobryan@gmail.com
 * @date    : Sun 31 December 2023
 * @time    : 1:36 pm
 */
class RecipeRepositoryImpl @Inject constructor(
    private val remoteSource: RecipeSearchApi
) : RecipeRepository {

    override suspend fun searchRecipes(type: RecipeType, query: String): DataResult<List<Recipe>> {
        return when (
            val result = remoteSource.fetchSearchedRecipes(type = type.name.lowercase(), query = query)
        ) {

            is NetworkResult.Error ->
                DataResult.Error(message = result.message)

            is NetworkResult.Success -> {
                val data = result.data
                DataResult.Success(data = data.recipes.map(RecipeDetailsDTO::toDomain))
            }
        }
    }

}