package com.example.tp_flashcard.models

// Represents a flashcard with a question and its answer
data class FlashCard (
    // Unique identifier for the card
    val id: String,

    // Identifier for the category this card belongs to
    val categoryId: String,

    // Text of the question shown to the user
    val question: String,

    // Text of the answer revealed after flipping the card
    val answer: String
)

// Represents a category grouping multiple flashcards
data class FlashCardCategory (
    // Unique identifier for the category
    val id: String,

    // Display name of the category
    val name: String
)
