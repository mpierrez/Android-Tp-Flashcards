package com.example.tp_flashcard.ui

import androidx.lifecycle.ViewModel
import com.example.tp_flashcard.models.FlashCardCategory
import com.example.tp_flashcard.repository.FlashcardRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : ViewModel() {

    // Propriété mutable interne
    private val _categories = MutableStateFlow<List<FlashCardCategory>>(emptyList())

    // Propriété exposée en lecture seule à l’UI
    val categories: StateFlow<List<FlashCardCategory>> = _categories.asStateFlow()

    // Chargement des données dès l'instanciation
    init { loadCategories() }

    private fun loadCategories() {
        // Ici les données sont codées en dur dans le repository
        _categories.value = FlashcardRepository.categories
    }
}
