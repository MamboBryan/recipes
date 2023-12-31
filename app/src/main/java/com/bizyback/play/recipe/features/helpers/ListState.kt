package com.bizyback.play.recipe.features.helpers

/**
 * @project : Recipe
 * @author  : mambo
 * @email   : mambobryan@gmail.com
 * @date    : Sun 31 December 2023
 * @time    : 2:57 pm
 */
sealed interface UiSuccessState<out T> {
    data object Empty : UiSuccessState<Nothing>
    data class Data<T>(val data: T) : UiSuccessState<T>
}

sealed interface UiListState<out T> {

    val hasData: Boolean
        get() = (this is Success) && (this.data is UiSuccessState.Data)

    data class Error(val message: String) : UiListState<Nothing>

    data class Success<T>(val data: UiSuccessState<T>) : UiListState<T>

    data object Loading : UiListState<Nothing>

    data object Idle : UiListState<Nothing>

}