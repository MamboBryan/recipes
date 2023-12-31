package com.bizyback.play.recipe.ui.presentation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.bizyback.play.recipe.features.landing.LandingScreen

/**
 * @project : Recipe
 * @author  : mambo
 * @email   : mambobryan@gmail.com
 * @date    : Sun 31 December 2023
 * @time    : 2:38 pm
 */
@Composable
fun MainNavigation(block: () -> Unit) {
    Navigator(LandingScreen)
}
