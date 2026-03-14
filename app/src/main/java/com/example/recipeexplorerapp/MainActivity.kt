package com.example.recipeexplorerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.recipeexplorerapp.data.Recipe
import com.example.recipeexplorerapp.ui.theme.RecipeExplorerAppTheme
import com.example.recipeexplorerapp.ui.util.RecipeDetailScreen
import com.example.recipeexplorerapp.ui.util.RecipeExplorerApp
import com.example.recipeexplorerapp.ui.util.RecipeViewModel

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun  onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecipeExplorerAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController() //instance of a new controller
                    val viewModel: RecipeViewModel = viewModel() //load RecipeViewModel, memories shared across diff screen
                    val windowSize = calculateWindowSizeClass(this)

                    //updates shared state, navigation for mobile phones
                    val changeToDetails : (Recipe) -> Unit = { recipe: Recipe ->
                        viewModel.setRecipe(recipe)

                        if(windowSize.widthSizeClass == WindowWidthSizeClass.Compact) {
                            navController.navigate("RecipeDetails/${recipe.id}")
                        }

                    }

                    NavHost(
                        navController = navController,
                        startDestination = "RecipeList",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        //on mobile, app opens to RecipeList at start of app
                        composable(route="RecipeList"){
                            RecipeExplorerApp(viewModel, windowSize, changeToDetails)
                        }

                        //on mobile, the second screen will have detail of recipe
                        composable(
                            route = "RecipeDetails/{recipeId}",
                            arguments = listOf(navArgument("recipeId") { type = NavType.IntType })
                        ) {
                            RecipeDetailScreen(viewModel, modifier = Modifier)
                        }
                    }
                }
            }
        }
    }
}
