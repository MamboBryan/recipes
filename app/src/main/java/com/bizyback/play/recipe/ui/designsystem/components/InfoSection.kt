package com.bizyback.play.recipe.ui.designsystem.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bizyback.play.recipe.features.recipesearch.CenteredColumn

/**
 * @project : Recipe
 * @author  : mambo
 * @email   : mambobryan@gmail.com
 * @date    : Sun 31 December 2023
 * @time    : 4:35 pm
 */
@Composable
fun InfoSection(
    icon: ImageVector,
    title: String,
    description: String,
    contentDescription: String,
    modifier: Modifier = Modifier,
    action: (@Composable () -> Unit)? = null,
) {
    CenteredColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Icon(
            modifier = Modifier
                .height(75.dp)
                .width(75.dp),
            imageVector = icon,
            contentDescription = contentDescription
        )
        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = title,
            fontSize = 32.sp
        )
        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = description,
            textAlign = TextAlign.Center
        )
        AnimatedVisibility(modifier = Modifier.padding(top = 16.dp), visible = action != null) {
            action?.invoke()
        }
    }
}

@Preview
@Composable
fun InfoSectionPreview() {
    InfoSection(
        icon = Icons.Rounded.Warning,
        title = "Kumethoka",
        description = "Sijui Kumeenda aje",
        contentDescription = "an icon to show end of the world"
    )
}