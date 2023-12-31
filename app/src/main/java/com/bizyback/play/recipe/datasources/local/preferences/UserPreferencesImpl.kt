package com.bizyback.play.recipe.datasources.local.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.bizyback.play.recipe.datasources.local.entity.QueryEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.mapLatest
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import javax.inject.Inject

/**
 * @project : Recipe
 * @author  : mambo
 * @email   : mambobryan@gmail.com
 * @date    : Sun 31 December 2023
 * @time    : 5:47 pm
 */
class UserPreferencesImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : UserPreferences {

    object Keys {
        val searchedWords = stringPreferencesKey("SEARCHED_WORDS")
    }

    override val searchedWords: Flow<List<QueryEntity>>
        get() = getSearchedWordsList()

    private fun getSearchedWordsList(): Flow<List<QueryEntity>> = dataStore.data.mapLatest {
        val json = it[Keys.searchedWords] ?: return@mapLatest emptyList()
        Json.decodeFromString(json)
    }

    private suspend fun updateSearchedWords(list: List<QueryEntity>) {
        dataStore.edit {
            val json = Json.encodeToString(list)
            it[Keys.searchedWords] = json
        }
    }

    override suspend fun addQuery(query: String) {
        val entity = QueryEntity(value = query)
        val list = getSearchedWordsList().firstOrNull()?.toMutableList() ?: mutableListOf()
        when {
            list.count() == 10 -> {
                list.removeAt(0)
                list.add(entity)
                updateSearchedWords(list)
            }

            list.any { it.value.equals(query, true) } -> {
                val index = list.indexOfFirst { it.value.equals(query, true) }
                list.removeAt(index)
                list.add(entity)
                updateSearchedWords(list)
            }

            else -> {
                list.add(entity)
                updateSearchedWords(list)
            }
        }

    }

    override suspend fun clearAllSearchedWords() {
        updateSearchedWords(listOf())
    }
}