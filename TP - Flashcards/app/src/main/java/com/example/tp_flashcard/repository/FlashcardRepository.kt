package com.example.tp_flashcard.repository

import com.example.tp_flashcard.models.FlashCard
import com.example.tp_flashcard.models.FlashCardCategory

object FlashcardRepository {
    // Liste des catégories de flashcards
    val categories : List <FlashCardCategory> = listOf (
        FlashCardCategory(id = "1", name = "Mathématiques"),
        FlashCardCategory(id = "2", name = "Science"),
        FlashCardCategory(id = "3", name = "Histoire"),
        FlashCardCategory(id = "4", name = "Geographie"),
        FlashCardCategory(id = "5", name = "Littérature")
    )

    // Liste des flashcards regroupées par catégorie
    val flashcards : List <FlashCard> = listOf (
        FlashCard(id = "1", categoryId = "1", question = "Quel est le résultat de 2 + 2 ?", answer = "4"),
        FlashCard(id = "2", categoryId = "1", question = "Quelle est la racine carrée de 16 ?", answer = "4"),
        FlashCard(id = "3", categoryId = "1", question = "Combien font 5 x 6 ?", answer = "30"),
        FlashCard(id = "4", categoryId = "1", question = "Quel est le résultat de 15 - 7 ?", answer = "8"),
        FlashCard(id = "5", categoryId = "1", question = "Combien font 9 ÷ 3 ?", answer = "3"),
        FlashCard(id = "6", categoryId = "1", question = "Quelle est la valeur de π approximativement ?", answer = "3,14"),
        FlashCard(id = "7", categoryId = "1", question = "Combien de côtés a un hexagone ?", answer = "6"),
        FlashCard(id = "8", categoryId = "1", question = "Quelle est la formule de l'aire d'un cercle ?", answer = "π × r²"),
        FlashCard(id = "9", categoryId = "1", question = "Quelle est la somme des angles d’un triangle ?", answer = "180 degrés"),
        FlashCard(id = "10", categoryId = "1", question = "Que vaut 10^3 ?", answer = "1000"),

        FlashCard(id = "11", categoryId = "2", question = "Qu'est-ce que H2O ?", answer = "L'eau"),
        FlashCard(id = "12", categoryId = "2", question = "Quel est le symbole chimique de l'or ?", answer = "Au"),
        FlashCard(id = "13", categoryId = "2", question = "Quelle planète est la plus proche du Soleil ?", answer = "Mercure"),
        FlashCard(id = "14", categoryId = "2", question = "Quel gaz respirons-nous principalement ?", answer = "L'oxygène"),
        FlashCard(id = "15", categoryId = "2", question = "Quel est l'état solide de l'eau ?", answer = "La glace"),
        FlashCard(id = "16", categoryId = "2", question = "Qu'est-ce que la photosynthèse ?", answer = "Processus par lequel les plantes produisent de l'énergie"),
        FlashCard(id = "17", categoryId = "2", question = "Quel organe pompe le sang dans le corps ?", answer = "Le cœur"),
        FlashCard(id = "18", categoryId = "2", question = "Quel est le principal gaz à effet de serre ?", answer = "Le dioxyde de carbone"),
        FlashCard(id = "19", categoryId = "2", question = "Quel est le symbole chimique de l'eau ?", answer = "H2O"),
        FlashCard(id = "20", categoryId = "2", question = "Qu'est-ce qu'un atome ?", answer = "La plus petite unité de la matière"),

        FlashCard(id = "21", categoryId = "3", question = "Qui était le premier président des États-Unis ?", answer = "George Washington"),
        FlashCard(id = "22", categoryId = "3", question = "Quand la Déclaration d'Indépendance a-t-elle été signée ?", answer = "1776"),
        FlashCard(id = "23", categoryId = "3", question = "Quelle guerre a eu lieu entre 1914 et 1918 ?", answer = "La Première Guerre mondiale"),
        FlashCard(id = "24", categoryId = "3", question = "Qui a découvert l'Amérique en 1492 ?", answer = "Christophe Colomb"),
        FlashCard(id = "25", categoryId = "3", question = "Quelle révolution a commencé en 1789 ?", answer = "La Révolution française"),
        FlashCard(id = "26", categoryId = "3", question = "Quel mur est tombé en 1989 ?", answer = "Le mur de Berlin"),
        FlashCard(id = "27", categoryId = "3", question = "Qui était Napoléon Bonaparte ?", answer = "Empereur français"),
        FlashCard(id = "28", categoryId = "3", question = "Quel était le but des Croisades ?", answer = "Reprendre Jérusalem"),
        FlashCard(id = "29", categoryId = "3", question = "Quel événement marque le début de la Seconde Guerre mondiale ?", answer = "L'invasion de la Pologne en 1939"),
        FlashCard(id = "30", categoryId = "3", question = "Qui était Cléopâtre ?", answer = "Reine d'Égypte"),

        FlashCard(id = "31", categoryId = "4", question = "Quelle est la capitale de la France ?", answer = "Paris"),
        FlashCard(id = "32", categoryId = "4", question = "Quel est le plus grand continent ?", answer = "L'Asie"),
        FlashCard(id = "33", categoryId = "4", question = "Quel est le plus long fleuve du monde ?", answer = "Le Nil"),
        FlashCard(id = "34", categoryId = "4", question = "Dans quel pays se trouve la Grande Muraille ?", answer = "La Chine"),
        FlashCard(id = "35", categoryId = "4", question = "Quel océan borde la côte ouest des États-Unis ?", answer = "L'océan Pacifique"),
        FlashCard(id = "36", categoryId = "4", question = "Quelle est la plus haute montagne du monde ?", answer = "L'Everest"),
        FlashCard(id = "37", categoryId = "4", question = "Quelle île est la plus grande du monde ?", answer = "Le Groenland"),
        FlashCard(id = "38", categoryId = "4", question = "Quelle est la capitale de l'Australie ?", answer = "Canberra"),
        FlashCard(id = "39", categoryId = "4", question = "Combien y a-t-il de continents ?", answer = "7"),
        FlashCard(id = "40", categoryId = "4", question = "Quel désert est le plus grand du monde ?", answer = "Le désert du Sahara"),

        FlashCard(id = "41", categoryId = "5", question = "Qui a écrit 'Roméo et Juliette' ?", answer = "William Shakespeare"),
        FlashCard(id = "42", categoryId = "5", question = "Quel est le roman le plus célèbre de Victor Hugo ?", answer = "Les Misérables"),
        FlashCard(id = "43", categoryId = "5", question = "Qui est l'auteur du 'Petit Prince' ?", answer = "Antoine de Saint-Exupéry"),
        FlashCard(id = "44", categoryId = "5", question = "Dans quel roman trouve-t-on Sherlock Holmes ?", answer = "Les Aventures de Sherlock Holmes"),
        FlashCard(id = "45", categoryId = "5", question = "Quel poète français est connu pour ses 'Fleurs du mal' ?", answer = "Charles Baudelaire"),
        FlashCard(id = "46", categoryId = "5", question = "Qui a écrit 'Le Comte de Monte-Cristo' ?", answer = "Alexandre Dumas"),
        FlashCard(id = "47", categoryId = "5", question = "Quel roman commence par 'Madame Bovary, c’est moi' ?", answer = "Madame Bovary"),
        FlashCard(id = "48", categoryId = "5", question = "Qui est l'auteur de 'Candide' ?", answer = "Voltaire"),
        FlashCard(id = "49", categoryId = "5", question = "Quel écrivain français est célèbre pour 'Les Trois Mousquetaires' ?", answer = "Alexandre Dumas"),
        FlashCard(id = "50", categoryId = "5", question = "Qui a écrit 'Germinal' ?", answer = "Émile Zola")
        )
}
