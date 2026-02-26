package com.example.session5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateDemoApp()
        }
    }
}

@Composable
fun StateDemoApp() {
    MaterialTheme {
        NameInputScreen()
    }
}

@Composable
fun NameInputScreen() {

    // STATE: Stores user input
    var name by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Enter your name:",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        // USER INPUT FIELD
        OutlinedTextField(
            value = name,
            onValueChange = { name = it }, // Updates state
            label = { Text("Your Name") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        // REAL-TIME UI UPDATE
        Text(
            text = if (name.isNotBlank())
                "Hello, $name!"
            else
                "Hello!"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewStateDemo() {
    StateDemoApp()
}