package com.example.recipeexplorerapp.ui.util

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.recipeexplorerapp.data.Recipe

@Composable
fun RecipeExplorerApp(viewModel: RecipeViewModel, windowSize: WindowSizeClass, changeToDetails: (Recipe) -> Unit) {

    //checks window size to dynamically switch between layout
    if (windowSize.widthSizeClass == WindowWidthSizeClass.Compact) {
        Column() {
            RecipeListScreen(changeToDetails, modifier = Modifier.fillMaxSize())
        }
    } else {
        Row(modifier = Modifier.fillMaxSize()) {

            //screen is distributed equally for tablet
            RecipeListScreen(changeToDetails, modifier = Modifier.weight(1f))
            RecipeDetailScreen(viewModel, modifier = Modifier.weight(1f))
        }
    }
}