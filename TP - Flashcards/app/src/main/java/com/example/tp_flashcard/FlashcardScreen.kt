import androidx.compose.animation.*
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.example.tp_flashcard.ui.FlashcardViewModel
import kotlinx.coroutines.launch

import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.text.style.TextAlign
import androidx.xr.compose.testing.toDp

@Composable
fun FlashcardScreen(
    flashcardViewModel: FlashcardViewModel,
    onFinish: () -> Unit
) {
    val uiState by flashcardViewModel.uiState.collectAsState()

    val rotation = remember { Animatable(0f) }
    val coroutineScope = rememberCoroutineScope()
    val density = LocalDensity.current.density

    val currentFlashcard = if (uiState.flashcards.isNotEmpty()) uiState.flashcards[uiState.currentIndex] else null

    LaunchedEffect(uiState.currentIndex) {
        rotation.snapTo(0f)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProgressBar(
            currentIndex = uiState.currentIndex,
            total = uiState.flashcards.size
        )

        if (!uiState.isFinished) {
            AnimatedContent(
                targetState = currentFlashcard,
                transitionSpec = {
                    (slideInHorizontally(animationSpec = tween(300)) { width -> width } +
                            fadeIn(animationSpec = tween(300))).togetherWith(
                        slideOutHorizontally(
                            animationSpec = tween(300)
                        ) { width -> -width } +
                                fadeOut(animationSpec = tween(300)))
                }
            ) { flashcard ->
                val showAnswer = rotation.value >= 90f

                if (flashcard != null) {
                    FlashcardCard(
                        text = if (showAnswer) flashcard.answer else flashcard.question,
                        modifier = Modifier
                            .graphicsLayer {
                                rotationY = rotation.value
                                cameraDistance = 8 * density
                                scaleX = if (rotation.value >= 90f) -1f else 1f
                            }
                            .clickable {
                                coroutineScope.launch {
                                    val target = if (rotation.value < 90f) 180f else 0f
                                    rotation.animateTo(target, animationSpec = tween(600))
                                }
                            }
                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp) // espace entre les boutons
            ) {
                Button(
                    onClick = {
                        flashcardViewModel.nextFlashcard(known = false)
                        coroutineScope.launch {
                            rotation.snapTo(0f)
                        }
                    },
                    enabled = uiState.flashcards.isNotEmpty(),
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.error
                    )
                ) {
                    Text(text = "Je ne le savais pas", textAlign = TextAlign.Center)
                }

                Button(
                    onClick = {
                        flashcardViewModel.nextFlashcard(known = true)
                        coroutineScope.launch {
                            rotation.snapTo(0f)
                        }
                    },
                    enabled = uiState.flashcards.isNotEmpty(),
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2E7D32)
                    )
                ) {
                    Text(text = "Je le savais", textAlign = TextAlign.Center)
                }
            }

        } else {
            // Pour revenir automatiquement à l'écran d'accueil, on peut juste appeler onFinish mais j'ai choisi de le faire via un bouton pour plus de clarté
            AlertDialog(
                onDismissRequest = { },
                title = {
                    Text(text = "Fin des révisions !")
                },
                text = {
                    Text(
                        text = "Vous avez répondu correctement à ${uiState.correctAnswers} questions" +
                                "\n\nVous avez répondu incorrectement à ${uiState.incorrectAnswers} questions",
                        style = MaterialTheme.typography.bodyLarge
                    )
                },
                confirmButton = {
                    Button(
                        onClick = onFinish,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        )
                    ) {
                        Text(text = "Retour à l'écran d'accueil")
                    }
                },
            )
        }
    }
}

@Composable
fun ProgressBar(currentIndex: Int, total: Int) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Carte ${currentIndex + 1} sur $total")
        Spacer(modifier = Modifier.height(8.dp))
        LinearProgressIndicator(
            progress = { if (total > 0) (currentIndex + 1) / total.toFloat() else 0f },
        )
    }
}

@Composable
fun FlashcardCard(text: String, modifier: Modifier = Modifier) {
    val containerHeight = LocalWindowInfo.current.containerSize.height.toDp() ?: 200.dp

    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(containerHeight * 0.5f)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(24.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}
