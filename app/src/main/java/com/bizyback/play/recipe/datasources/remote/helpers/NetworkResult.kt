package com.bizyback.play.recipe.datasources.remote.helpers

/**
 * @project : Recipe
 * @author  : mambo
 * @email   : mambobryan@gmail.com
 * @date    : Sun 31 December 2023
 * @time    : 11:32 am
 */
sealed interface NetworkResult<out T> {
    data class Error(val message: String, val exception: Exception) : NetworkResult<Nothing>
    data class Success<T>(val data: T) : NetworkResult<T>
}