package com.example.recipeexplorerapp.ui.util

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeDetailScreen(
    viewModel: RecipeViewModel,
    recipeId: Int? = null,
    modifier: Modifier = Modifier
) {
    val data = viewModel.uiState.collectAsStateWithLifecycle()
    val recipe = data.value

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    val displayTitle: String
                    if (recipe.name.isNotEmpty()) {
                        displayTitle = recipe.name
                    } else {
                        displayTitle = "Recipe Explorer"
                    }

                    Text(
                        text = displayTitle,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            )
        },
        modifier = modifier
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            if (recipe.name == "") {
                Text(
                    text = "Please select a recipe.",
                    style = MaterialTheme.typography.bodyLarge
                )
            } else {
                Text(
                    text = recipe.description,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}