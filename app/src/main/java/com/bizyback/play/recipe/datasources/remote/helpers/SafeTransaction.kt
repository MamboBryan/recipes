package com.bizyback.play.recipe.datasources.remote.helpers

import timber.log.Timber

/**
 * @project : Recipe
 * @author  : mambo
 * @email   : mambobryan@gmail.com
 * @date    : Sun 31 December 2023
 * @time    : 12:04 pm
 */

suspend fun <T> safeApiCall(errorMessage: String = "", block: suspend () -> T): NetworkResult<T> {
    return try {
        val data = block.invoke()
        NetworkResult.Success(data = data)
    } catch (e: Exception) {
        Timber.e(e)
        NetworkResult.Error(message = e.localizedMessage ?: errorMessage, exception = e)
    }
}