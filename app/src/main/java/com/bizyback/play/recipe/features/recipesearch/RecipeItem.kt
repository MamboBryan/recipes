package com.bizyback.play.recipe.features.recipesearch

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.bizyback.play.recipe.data.domain.models.Recipe

/**
 * @project : Recipe
 * @author  : mambo
 * @email   : mambobryan@gmail.com
 * @date    : Sun 31 December 2023
 * @time    : 4:11 pm
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeItem(
    recipe: Recipe,
    modifier: Modifier = Modifier,
    onRecipeClicked: () -> Unit
) {
    Card(
        modifier = modifier
            .padding(8.dp),
        onClick = onRecipeClicked
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(recipe.image)
                .crossfade(true)
                .build(),
            contentDescription = "recipe image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(16.dp)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = recipe.label,
                color = Color.Black,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}