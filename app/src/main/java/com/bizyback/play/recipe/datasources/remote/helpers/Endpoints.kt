package com.bizyback.play.recipe.datasources.remote.helpers

/**
 * @project : Recipe
 * @author  : mambo
 * @email   : mambobryan@gmail.com
 * @date    : Sun 31 December 2023
 * @time    : 11:38 am
 */
sealed class Endpoints(private val path: String) {

    val url: String
        get() = buildString {
            append("https://api.edamam.com/")
            append(path)
        }

    data object Recipe {

        data object Search : Endpoints(path = "api/recipes/v2/")

    }

}