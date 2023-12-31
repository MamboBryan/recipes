package com.bizyback.play.recipe.features.recipesearch

import cafe.adriel.voyager.core.model.screenModelScope
import com.bizyback.play.recipe.data.domain.models.DataResult
import com.bizyback.play.recipe.data.domain.models.Recipe
import com.bizyback.play.recipe.data.domain.repositories.RecipeRepository
import com.bizyback.play.recipe.data.domain.repositories.UserRepository
import com.bizyback.play.recipe.features.helpers.MutableScreenState
import com.bizyback.play.recipe.features.helpers.UiListState
import com.bizyback.play.recipe.features.helpers.UiSuccessState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @project : Recipe
 * @author  : mambo
 * @email   : mambobryan@gmail.com
 * @date    : Sun 31 December 2023
 * @time    : 2:54 pm
 */
data class RecipeSearchScreenUiState(
    val isDarkModeEnabled: Boolean = true,
    val query: String = "",
    val searchedWords: List<String> = emptyList(),
    val isLoading: Boolean = false,
    val listState: UiListState<List<Recipe>> = UiListState.Idle
)

class RecipeSearchModel @Inject constructor(
    private val recipeRepository: RecipeRepository,
    private val userRepository: UserRepository
) : MutableScreenState<RecipeSearchScreenUiState>(RecipeSearchScreenUiState()) {

    init {
        observeDarkModeTheme()
        getPreviousSearchedWords()
    }

    private fun observeDarkModeTheme() {
        screenModelScope.launch {
            userRepository.isDarkModeEnabled.collectLatest {
                update { copy(isDarkModeEnabled = it) }
            }
        }
    }

    fun updateDarkModeTheme() {
        screenModelScope.launch {
            userRepository.updateDarkModeTheme()
        }
    }

    private fun getPreviousSearchedWords() {
        screenModelScope.launch {
            recipeRepository.searchedWords.collectLatest { queries ->
                update { copy(searchedWords = queries) }
            }
        }
    }

    fun onRetry() {
        onSearchClicked()
    }

    fun updateQuery(query: String) {
        update { copy(query = query) }
    }

    fun onSearchClicked() {
        screenModelScope.launch {
            val query = state.value.query
            if (query.isBlank()) return@launch
            if (state.value.listState.hasData)
                update { copy(isLoading = true) }
            else
                update { copy(listState = UiListState.Loading) }
            val result = recipeRepository.searchRecipes(query = query)
            when (result) {
                is DataResult.Error -> {
                    update { copy(listState = UiListState.Error(message = result.message)) }
                }

                is DataResult.Success -> {
                    update { copy(isLoading = false) }
                    val data = result.data
                    if (data.isEmpty())
                        update { copy(listState = UiListState.Success(data = UiSuccessState.Empty)) }
                    else
                        update {
                            copy(
                                listState = UiListState.Success(
                                    data = UiSuccessState.Data(data = data)
                                )
                            )
                        }

                }
            }
        }
    }

}