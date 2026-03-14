package com.example.recipeexplorerapp.ui.util

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.recipeexplorerapp.data.Recipe

@Composable
fun RecipeItem(recipe: Recipe, changeToDetails: (Recipe) -> Unit){

    //allows clickable card to change to detail of recipe
    Card(onClick = {
        changeToDetails(recipe)
    }) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
        ) {
            Text(text = recipe.name, fontWeight = FontWeight.Bold)
            Text(text = recipe.description)
        }
    }
}