package com.bizyback.play.recipe.features.recipesearch

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getScreenModel
import com.bizyback.play.recipe.R
import com.bizyback.play.recipe.features.helpers.UiListState
import com.bizyback.play.recipe.features.helpers.UiSuccessState
import com.bizyback.play.recipe.ui.designsystem.components.InfoSection

/**
 * @project : Recipe
 * @author  : mambo
 * @email   : mambobryan@gmail.com
 * @date    : Sun 31 December 2023
 * @time    : 2:52 pm
 */
object RecipeSearchScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        val screenModel: RecipeSearchModel = getScreenModel()
        val state by screenModel.state.collectAsState()
        RecipeSearchScreenContent(
            state = state,
            onSearchQueryUpdated = screenModel::updateQuery,
            onRetryClicked = screenModel::onRetry,
            onSearchClicked = screenModel::onSearchClicked,
            onUpdateThemeClicked = screenModel::updateDarkModeTheme
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RecipeSearchScreenContent(
    state: RecipeSearchScreenUiState,
    onSearchQueryUpdated: (String) -> Unit,
    onRetryClicked: () -> Unit,
    onSearchClicked: () -> Unit,
    onUpdateThemeClicked: () -> Unit
) {
    Scaffold(topBar = {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
                .padding(vertical = 8.dp, horizontal = 16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    fontSize = MaterialTheme.typography.displaySmall.fontSize
                )

                val icon =
                    painterResource(id = if (!state.isDarkModeEnabled) R.drawable.darkmode else R.drawable.lightmode)
                IconButton(onClick = onUpdateThemeClicked) {
                    Icon(
                        modifier = Modifier
                            .height(24.dp)
                            .width(24.dp),
                        painter = icon,
                        contentDescription = "dark mode theme  toggle"
                    )
                }
            }

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colorScheme.background),
                singleLine = true,
                placeholder = { Text(text = "Search...") },
                value = state.query,
                onValueChange = onSearchQueryUpdated,
                trailingIcon = {
                    IconButton(
                        enabled = state.query.isNotBlank() or (state.listState !is UiListState.Loading),
                        onClick = onSearchClicked
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Search,
                            contentDescription = "search food"
                        )
                    }
                },
                shape = RoundedCornerShape(25.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.background,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surface
                )
            )
            AnimatedVisibility(visible = state.searchedWords.isNotEmpty()) {
                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(state.searchedWords) {
                        FilterChip(
                            selected = state.query == it,
                            onClick = {
                                onSearchQueryUpdated.invoke(it)
                                onSearchClicked.invoke()
                            },
                            label = {
                                Text(text = it)
                            }
                        )
                    }
                }
            }
        }
    }) {
        Column(
            modifier = Modifier.padding(it)
        ) {

            AnimatedVisibility(visible = state.isLoading) {
                LinearProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )
            }

            when (val result = state.listState) {
                is UiListState.Error -> {
                    InfoSection(
                        icon = Icons.Rounded.List,
                        title = "Error",
                        description = result.message,
                        contentDescription = "error fetching results"
                    ) {
                        Button(modifier = Modifier.padding(top = 16.dp), onClick = onRetryClicked) {
                            Text(text = "Retry")
                        }
                    }
                }

                UiListState.Loading -> {
                    CenteredColumn(modifier = Modifier.fillMaxSize()) {
                        CircularProgressIndicator()
                    }
                }

                is UiListState.Success -> {
                    when (val listData = result.data) {
                        UiSuccessState.Empty -> {
                            InfoSection(
                                icon = Icons.Rounded.List,
                                title = "Empty",
                                description = "No recipes found for ${state.query}",
                                contentDescription = "empty icon"
                            )
                        }

                        is UiSuccessState.Data -> {
                            val list = listData.data
                            LazyColumn {
                                items(list) { recipe ->
                                    RecipeItem(recipe = recipe) {

                                    }
                                }
                            }
                        }
                    }
                }

                UiListState.Idle -> {
                    InfoSection(
                        icon = Icons.Rounded.Search,
                        title = "Search",
                        description = "Search any food item to proceed",
                        contentDescription = "search food item"
                    )
                }
            }
        }
    }
}

@Composable
fun CenteredColumn(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        content.invoke()
    }
}