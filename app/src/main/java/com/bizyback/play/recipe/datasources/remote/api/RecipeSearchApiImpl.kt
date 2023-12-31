package com.bizyback.play.recipe.datasources.remote.api

import com.bizyback.play.recipe.datasources.remote.dto.RecipeSearchResponseDTO
import com.bizyback.play.recipe.datasources.remote.helpers.Endpoints
import com.bizyback.play.recipe.datasources.remote.helpers.Endpoints.Recipe.Search.url
import com.bizyback.play.recipe.datasources.remote.helpers.NetworkResult
import com.bizyback.play.recipe.datasources.remote.helpers.safeApiCall
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import io.ktor.http.Url
import javax.inject.Inject

/**
 * @project : Recipe
 * @author  : mambo
 * @email   : mambobryan@gmail.com
 * @date    : Sun 31 December 2023
 * @time    : 11:34 am
 */
class RecipeSearchApiImpl @Inject constructor(
    private val client: HttpClient
) : RecipeSearchApi {

    private fun HttpRequestBuilder.addAuthenticationQueryParameters() {
        parameter("app_key", "eae736ace3a235647a0ab93ed2bb26f2")
        parameter("app_id", "f4123019")
    }

    override suspend fun fetchSearchedRecipes(
        type: String, query: String
    ): NetworkResult<RecipeSearchResponseDTO> =
        safeApiCall(errorMessage = "Failed fetching recipes") {
            val response = client.get {
                url(urlString = Endpoints.Recipe.Search.url)
                addAuthenticationQueryParameters()
                parameter("type", type)
                parameter("q", query)
            }
            response.body()
        }

}