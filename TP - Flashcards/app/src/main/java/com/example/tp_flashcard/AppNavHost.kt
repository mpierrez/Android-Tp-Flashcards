package com.example.tp_flashcard

import FlashcardScreen
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tp_flashcard.ui.FlashcardViewModel
import com.example.tp_flashcard.ui.HomeViewModel

@Composable
fun AppNavHost(homeViewModel: HomeViewModel, flashcardViewModel: FlashcardViewModel) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                homeViewModel = homeViewModel,
                onCategoryClick = { category ->
                    // On navigue vers l'écran de révision avec l'ID de la catégorie
                    navController.navigate("review/${category.id}")
                }
            )
        }

        composable("review/{categoryId}") { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getString("categoryId")

            if (categoryId != null) {
                flashcardViewModel.loadFlashcardsForCategory(categoryId)

                FlashcardScreen(
                    flashcardViewModel = flashcardViewModel,
                    onFinish = {
                        navController.navigate("home") {
                            popUpTo("home") { inclusive = true }
                        }
                    }
                )
            } else {
                Toast.makeText(navController.context, "Erreur : catégorie introuvable", Toast.LENGTH_SHORT).show()
                navController.navigate("home") {
                    popUpTo("home") { inclusive = true }
                }
            }
        }
    }
}
