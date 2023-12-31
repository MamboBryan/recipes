package com.bizyback.play.recipe.datasources.local.preferences

import com.bizyback.play.recipe.datasources.local.entity.QueryEntity
import kotlinx.coroutines.flow.Flow

/**
 * @project : Recipe
 * @author  : mambo
 * @email   : mambobryan@gmail.com
 * @date    : Sun 31 December 2023
 * @time    : 5:42 pm
 */
interface UserPreferences {

    val searchedWords: Flow<List<QueryEntity>>

    suspend fun addQuery(query: String)

    suspend fun clearAllSearchedWords()

}