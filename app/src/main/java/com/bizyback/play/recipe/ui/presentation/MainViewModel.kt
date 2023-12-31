package com.bizyback.play.recipe.ui.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bizyback.play.recipe.data.domain.repositories.UserRepository
import com.bizyback.play.recipe.features.helpers.StateViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @project : Recipe
 * @author  : mambo
 * @email   : mambobryan@gmail.com
 * @date    : Sun 31 December 2023
 * @time    : 6:39 pm
 */

data class MainUiState(
    val isDarkModeEnabled: Boolean = true,
    val isNetworkConnected: Boolean = true
)

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: UserRepository
) : StateViewModel<MainUiState>(MainUiState()) {

    init {
        observeDarkModeTheme()
    }

    private fun observeDarkModeTheme() {
        viewModelScope.launch {
            repository.isDarkModeEnabled.collectLatest {
                update { copy(isDarkModeEnabled = it) }
            }
        }
    }

}