package com.example.session9

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Session9App()
        }
    }
}

// Data class with nullable fields
data class User(
    val name: String,
    val email: String?,
    val age: Int?
)

@Composable
fun Session9App() {
    MaterialTheme {
        UserStatusScreen()
    }
}

@Composable
fun UserStatusScreen() {

    var name by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var ageInput by rememberSaveable { mutableStateOf("") }

    val user = User(
        name = name,
        email = email.takeIf { it.isNotBlank() },
        age = ageInput.toIntOrNull()
    )

    val emailStatus = user.email ?: "No email provided"

    val ageStatus = when {
        user.age == null -> "Age not available"
        user.age < 18 -> "Minor"
        user.age in 18..60 -> "Adult"
        else -> "Senior"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text("User Status Checker", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email (optional)") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = ageInput,
            onValueChange = { ageInput = it },
            label = { Text("Age (optional)") }
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text("Email: $emailStatus")
        Text("Age Status: $ageStatus")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserStatusScreen() {
    Session9App()
}