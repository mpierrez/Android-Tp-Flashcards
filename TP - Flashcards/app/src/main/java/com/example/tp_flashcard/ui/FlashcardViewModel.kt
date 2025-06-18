package com.example.tp_flashcard.ui

import androidx.lifecycle.ViewModel
import com.example.tp_flashcard.repository.FlashcardRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FlashcardViewModel : ViewModel() {

    // MutableStateFlow privé contenant l'état UI
    private val _uiState = MutableStateFlow(FlashcardUiState())

    // Exposition en lecture seule à l'UI
    val uiState: StateFlow<FlashcardUiState> = _uiState.asStateFlow()

    // Charge les cartes correspondant à une catégorie donnée
    fun loadFlashcardsForCategory(categoryId: String) {
        val cards = FlashcardRepository.flashcards.filter { it.categoryId == categoryId }
        _uiState.value = FlashcardUiState(
            flashcards = cards,
            isFinished = cards.isEmpty()
        )
    }

    fun nextFlashcard(known: Boolean = false) {
        val state = _uiState.value
        val nextIndex = state.currentIndex + 1

        // Met à jour le nombre de réponses correctes ou incorrectes
        val updatedState = if (known) {
            state.copy(correctAnswers = state.correctAnswers + 1)
        } else {
            state.copy(incorrectAnswers = state.incorrectAnswers + 1)
        }

        // Vérifie si on a atteint la fin de la liste des cartes
        val finalState = if (nextIndex >= state.flashcards.size) {
            updatedState.copy(isFinished = true)
        } else {
            updatedState.copy(currentIndex = nextIndex)
        }

        _uiState.value = finalState
    }
}
