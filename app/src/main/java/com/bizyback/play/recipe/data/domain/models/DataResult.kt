package com.bizyback.play.recipe.data.domain.models

/**
 * @project : Recipe
 * @author  : mambo
 * @email   : mambobryan@gmail.com
 * @date    : Sun 31 December 2023
 * @time    : 1:38 pm
 */
sealed interface DataResult<out T> {

    data class Error(val message: String) : DataResult<Nothing>

    data class Success<T>(val data: T) : DataResult<T>

}