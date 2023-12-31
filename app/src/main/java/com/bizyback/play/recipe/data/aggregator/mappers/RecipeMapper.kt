package com.bizyback.play.recipe.data.aggregator.mappers

import com.bizyback.play.recipe.data.domain.models.Recipe
import com.bizyback.play.recipe.datasources.remote.dto.RecipeDetailsDTO

/**
 * @project : Recipe
 * @author  : mambo
 * @email   : mambobryan@gmail.com
 * @date    : Sun 31 December 2023
 * @time    : 1:47 pm
 */
fun RecipeDetailsDTO.toDomain() = Recipe(label = recipe.label, image = recipe.image)