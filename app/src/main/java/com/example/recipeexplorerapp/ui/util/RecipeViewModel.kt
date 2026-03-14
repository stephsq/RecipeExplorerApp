package com.example.recipeexplorerapp.ui.util

import androidx.lifecycle.ViewModel
import com.example.recipeexplorerapp.data.Recipe
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RecipeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(Recipe(0, "",""))
    val uiState: StateFlow<Recipe> = _uiState.asStateFlow()

    fun setRecipe(recipe: Recipe) {
        _uiState.value = recipe
    }

    fun getRecipe(): Recipe {
        return _uiState.value
    }
}