package com.bizyback.play.recipe.features.helpers

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * @project : Recipe
 * @author  : mambo
 * @email   : mambobryan@gmail.com
 * @date    : Sun 31 December 2023
 * @time    : 6:47 pm
 */
open class StateViewModel<T>(initial: T) : ViewModel() {

    private val _state = MutableStateFlow(initial)
    val state get() = _state.asStateFlow()

    fun update(value: T) {
        _state.value = value
    }

    fun update(block: T.() -> T) {
        update(state.value.block())
    }


}