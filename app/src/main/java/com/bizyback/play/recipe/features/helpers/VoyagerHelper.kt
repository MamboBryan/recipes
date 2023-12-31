package com.bizyback.play.recipe.features.helpers

import cafe.adriel.voyager.core.model.StateScreenModel

/**
 * @project : Recipe
 * @author  : mambo
 * @email   : mambobryan@gmail.com
 * @date    : Sun 31 December 2023
 * @time    : 3:17 pm
 */

open class MutableScreenState<T>(initial: T) : StateScreenModel<T>(initialState = initial) {

    fun update(value: T) {
        mutableState.value = value
    }

    fun update(block: T.() -> T) {
        update(state.value.block())
    }

}