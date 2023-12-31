package com.bizyback.play.recipe.datasources.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @project : Recipe
 * @author  : mambo
 * @email   : mambobryan@gmail.com
 * @date    : Sun 31 December 2023
 * @time    : 11:27 am
 */
@Serializable
data class RecipeSearchResponseDTO(
    val from: Int,
    val to: Int,
    @SerialName("count")
    val totalRecipes: Long,
    @SerialName("hits")
    val recipes: List<RecipeDetailsDTO>
)

@Serializable
data class RecipeDetailsDTO(val recipe: RecipeDTO)

@Serializable
data class RecipeDTO(val label: String, val image: String)