package com.bizyback.play.recipe.data.aggregator.respositories

import com.bizyback.play.recipe.data.aggregator.mappers.toDomain
import com.bizyback.play.recipe.data.domain.models.DataResult
import com.bizyback.play.recipe.data.domain.models.Recipe
import com.bizyback.play.recipe.data.domain.models.RecipeType
import com.bizyback.play.recipe.data.domain.repositories.RecipeRepository
import com.bizyback.play.recipe.datasources.local.preferences.UserPreferences
import com.bizyback.play.recipe.datasources.remote.api.RecipeSearchApi
import com.bizyback.play.recipe.datasources.remote.dto.RecipeDetailsDTO
import com.bizyback.play.recipe.datasources.remote.helpers.NetworkResult
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapLatest
import javax.inject.Inject

/**
 * @project : Recipe
 * @author  : mambo
 * @email   : mambobryan@gmail.com
 * @date    : Sun 31 December 2023
 * @time    : 1:36 pm
 */
@OptIn(ExperimentalCoroutinesApi::class)
class RecipeRepositoryImpl @Inject constructor(
    private val remoteSource: RecipeSearchApi,
    private val userPreferences: UserPreferences,
) : RecipeRepository {

    override val searchedWords: Flow<List<String>>
        get() = userPreferences.searchedWords.mapLatest { entities ->
            entities.sortedByDescending { it.timestamp }.map { it.value }
        }

    override suspend fun searchRecipes(type: RecipeType, query: String): DataResult<List<Recipe>> {
        userPreferences.addQuery(query = query)
        return when (
            val result =
                remoteSource.fetchSearchedRecipes(type = type.name.lowercase(), query = query)
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