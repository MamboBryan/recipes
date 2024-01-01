package com.bizyback.play.recipe.datasources.remote.api

import com.bizyback.play.recipe.BuildConfig
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
import io.ktor.client.statement.bodyAsText
import io.ktor.http.Url
import timber.log.Timber
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
        parameter("app_key", BuildConfig.AppKey)
        parameter("app_id", BuildConfig.AppId)
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
            Timber.d("RESPONSE -> \n${response.bodyAsText()}")
            response.body()
        }

}