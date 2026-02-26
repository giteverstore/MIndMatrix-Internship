package com.example.session8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtGalleryApp()
        }
    }
}

// Data class
data class Artwork(
    val title: String,
    val artist: String,
    val year: Int
)

@Composable
fun ArtGalleryApp() {
    MaterialTheme {
        ArtGalleryScreen()
    }
}

@Composable
fun ArtGalleryScreen() {

    val artworks = listOf(
        Artwork("Starry Night", "Vincent van Gogh", 1889),
        Artwork("Mona Lisa", "Leonardo da Vinci", 1503),
        Artwork("The Persistence of Memory", "Salvador Dali", 1931)
    )

    var currentIndex by rememberSaveable { mutableStateOf(0) }

    val currentArtwork = artworks[currentIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = currentArtwork.title,
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text("${currentArtwork.artist}, ${currentArtwork.year}")

        Spacer(modifier = Modifier.height(30.dp))

        Row {

            Button(
                onClick = {
                    currentIndex =
                        if (currentIndex == 0)
                            artworks.size - 1
                        else
                            currentIndex - 1
                }
            ) {
                Text("Previous")
            }

            Spacer(modifier = Modifier.width(20.dp))

            Button(
                onClick = {
                    currentIndex =
                        if (currentIndex == artworks.size - 1)
                            0
                        else
                            currentIndex + 1
                }
            ) {
                Text("Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGallery() {
    ArtGalleryApp()
}