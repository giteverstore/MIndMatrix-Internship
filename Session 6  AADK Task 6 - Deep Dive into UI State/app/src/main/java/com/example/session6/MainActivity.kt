package com.example.session6

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
            Session6App()
        }
    }
}

/*
 * Represents different screens in the app
 */
enum class Screen {
    HOME,
    DETAILS
}

@Composable
fun Session6App() {

    // Screen state survives configuration changes
    var currentScreen by rememberSaveable { mutableStateOf(Screen.HOME) }

    MaterialTheme {
        when (currentScreen) {
            Screen.HOME -> HomeScreen(
                onNavigateToDetails = { currentScreen = Screen.DETAILS }
            )
            Screen.DETAILS -> DetailScreen(
                onBack = { currentScreen = Screen.HOME }
            )
        }
    }
}

/*
 * Home Screen
 * Demonstrates counter + toggle state
 */
@Composable
fun HomeScreen(onNavigateToDetails: () -> Unit) {

    var counter by rememberSaveable { mutableStateOf(0) }
    var isEnabled by rememberSaveable { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Home Screen",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text("Counter: $counter")

        Spacer(modifier = Modifier.height(10.dp))

        Row {
            Button(
                enabled = isEnabled,
                onClick = { counter++ }
            ) {
                Text("Increment")
            }

            Spacer(modifier = Modifier.width(10.dp))

            OutlinedButton(
                onClick = { isEnabled = !isEnabled }
            ) {
                Text(if (isEnabled) "Disable" else "Enable")
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = onNavigateToDetails) {
            Text("Go to Details")
        }
    }
}

/*
 * Details Screen
 * Demonstrates screen state transition
 */
@Composable
fun DetailScreen(onBack: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Details Screen",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text("This screen is controlled by structured UI state.")

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = onBack) {
            Text("Back")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSession6() {
    Session6App()
}