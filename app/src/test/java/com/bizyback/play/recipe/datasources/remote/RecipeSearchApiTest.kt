package com.bizyback.play.recipe.datasources.remote

import com.bizyback.play.recipe.datasources.remote.dto.RecipeSearchResponseDTO
import com.bizyback.play.recipe.datasources.remote.helpers.NetworkResult
import io.ktor.http.HttpStatusCode
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.Test

/**
 * @project : Recipe
 * @author  : mambo
 * @email   : mambobryan@gmail.com
 * @date    : Sun 31 December 2023
 * @time    : 12:10 pm
 */
class RecipeSearchApiTest {

    private val json = Json {
        ignoreUnknownKeys = true
    }

    @Test
    fun `given RecipeSearchApi, when searching for recipes, should return NetworkResultSuccess`() =
        runTest {
            val api = generateFakeRecipeSearchApiImpl(
                statusCode = HttpStatusCode.OK,
                response = RECIPE_SEARCH_VALID_RESPONSE
            )
            val response = api.fetchSearchedRecipes(query = "banana")
            assert(response is NetworkResult.Success)
        }

    @Test
    fun `given RecipeSearchApi, when searching for recipes, list should not be empty`() =
        runTest {
            val api = generateFakeRecipeSearchApiImpl(
                statusCode = HttpStatusCode.OK,
                response = RECIPE_SEARCH_VALID_RESPONSE
            )
            val response = api.fetchSearchedRecipes(query = "banana")
            assert(response is NetworkResult.Success)

            val data = json.decodeFromString<RecipeSearchResponseDTO>(RECIPE_SEARCH_VALID_RESPONSE)
            val responseData = (response as NetworkResult.Success).data
            assertEquals(responseData, data)
        }

}