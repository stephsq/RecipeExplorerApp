package com.example.recipeexplorerapp.ui.util

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.recipeexplorerapp.data.Recipe

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeListScreen(changeToDetails: (Recipe) -> Unit, modifier: Modifier = Modifier){
    val recipeList = listOf(
        Recipe(1, "Spaghetti Bolognese", "A classic Italian dish with rich meat sauce."),
        Recipe(2, "Chicken Curry", "A spicy and savory curry with tender chicken pieces."),
        Recipe(3, "Beef Stroganoff", "A creamy dish with sauteed pieces of beef and mushrooms.")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Recipe List",
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            )
        },
        modifier = modifier
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(recipeList) { recipe ->
                RecipeItem(recipe, changeToDetails)
            }
        }
    }
}

