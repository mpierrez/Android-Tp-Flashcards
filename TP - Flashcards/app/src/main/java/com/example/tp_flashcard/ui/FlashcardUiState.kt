package com.example.tp_flashcard.ui

import com.example.tp_flashcard.models.FlashCard

data class FlashcardUiState(
    val currentIndex: Int = 0,
    val flashcards: List<FlashCard> = emptyList(),
    val isFinished: Boolean = false,
    val correctAnswers: Int = 0,
    val incorrectAnswers: Int = 0
)
