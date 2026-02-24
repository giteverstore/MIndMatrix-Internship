package com.example.session2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.session2.ui.theme.Session2Theme
import android.content.res.Configuration

/*
 * MainActivity
 * Entry point of the application.
 * setContent replaces XML layout and loads Compose UI.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Applies Material3 theme to entire app
        setContent {
            Session2Theme {
                HomeScreen()
            }
        }
    }
}

/*
 * HomeScreen()
 * Uses Box layout primitive.
 * Box allows stacking and centering of content.
 */
@Composable
fun HomeScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()      // Occupies entire screen
            .padding(16.dp),    // Adds outer margin
        contentAlignment = Alignment.Center // Centers child composable
    ) {
        ProfileCard()
    }
}

/*
 * Light Mode Preview
 * Used to test responsiveness at specific screen size.
 */
@Preview(
    showBackground = true,
    widthDp = 320,
    heightDp = 640
)
@Composable
fun PreviewHomeScreen() {
    Session2Theme {
        HomeScreen()
    }
}

/*
 * Dark Mode Preview
 * Demonstrates accessibility and theme adaptability.
 */
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    widthDp = 320,
    heightDp = 640
)
@Composable
fun DarkPreview() {
    Session2Theme {
        HomeScreen()
    }
}

/*
 * ProfileCard()
 * Demonstrates:
 * - State management (remember + mutableStateOf)
 * - Column layout
 * - Row layout
 * - Modifier chaining
 * - Accessibility semantics
 * - Material3 Card component
 */
@Composable
fun ProfileCard() {

    // State variable to track Follow button status
    // When changed, Compose automatically recomposes UI
    var isFollowing by remember { mutableStateOf(false) }

    // Card provides elevation and visual grouping
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large, // Rounded corners
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {

        // Column arranges children vertically
        Column(
            modifier = Modifier
                .padding(24.dp) // Internal spacing inside card
        ) {

            // Primary heading text
            Text(
                text = "Avi",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(6.dp)) // Controlled spacing

            // Secondary information
            Text(
                text = "Software Engineering Student",
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = "Android & Networking Enthusiast",
                style = MaterialTheme.typography.bodySmall
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Row arranges buttons horizontally
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                /*
                 * Follow Button
                 * - Uses weight() for equal distribution
                 * - Uses semantics for accessibility
                 */
                Button(
                    modifier = Modifier
                        .weight(1f)
                        .semantics {
                            contentDescription = "Follow this profile"
                        },
                    onClick = {
                        // Toggle follow state
                        isFollowing = !isFollowing
                    }
                ) {
                    Text(if (isFollowing) "Following" else "Follow")
                }

                /*
                 * Message Button
                 * OutlinedButton gives visual contrast.
                 */
                OutlinedButton(
                    modifier = Modifier.weight(1f),
                    onClick = {}
                ) {
                    Text("Message")
                }
            }
        }
    }
}