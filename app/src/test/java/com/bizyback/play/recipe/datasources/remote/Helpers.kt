package com.bizyback.play.recipe.datasources.remote

import com.bizyback.play.recipe.datasources.remote.api.RecipeSearchApi
import com.bizyback.play.recipe.datasources.remote.api.RecipeSearchApiImpl
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headers
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

/**
 * @project : Recipe
 * @author  : mambo
 * @email   : mambobryan@gmail.com
 * @date    : Sun 31 December 2023
 * @time    : 12:13 pm
 */
private fun generateFakeEngine(statusCode: HttpStatusCode, response: String) = MockEngine {
    val headers = headers {
        append(HttpHeaders.ContentType, "application/json")
    }
    respond(content = response, status = statusCode, headers = headers)
}

private fun generateFakeClient(engine: HttpClientEngine) = HttpClient(engine) {
    install(ContentNegotiation) {
        json(Json {
            ignoreUnknownKeys = true
        })
    }
    install(DefaultRequest) {
        header(HttpHeaders.ContentType, ContentType.Application.Json)
    }
}

fun generateFakeRecipeSearchApiImpl(statusCode: HttpStatusCode, response: String): RecipeSearchApi =
    RecipeSearchApiImpl(
        client = generateFakeClient(engine = generateFakeEngine(statusCode, response))
    )