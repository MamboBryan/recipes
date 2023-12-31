package com.bizyback.play.recipe.datasources.local.entity

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

/**
 * @project : Recipe
 * @author  : mambo
 * @email   : mambobryan@gmail.com
 * @date    : Sun 31 December 2023
 * @time    : 7:21 pm
 */
class RecipeCache() : RealmObject {
    @PrimaryKey
    val id: String = ""
    val label: String = ""
    val image: String = ""

}