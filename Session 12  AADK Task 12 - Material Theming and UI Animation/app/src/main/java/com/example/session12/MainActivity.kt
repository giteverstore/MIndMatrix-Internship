package com.example.session12

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Session12App()
        }
    }
}

@Composable
fun Session12App() {

    var isDarkTheme by remember { mutableStateOf(false) }

    val backgroundColor by animateColorAsState(
        if (isDarkTheme) Color(0xFF121212) else Color(0xFFF5F5F5)
    )

    val textColor by animateColorAsState(
        if (isDarkTheme) Color.White else Color.Black
    )

    MaterialTheme(
        typography = Typography(
            titleLarge = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor),
            contentAlignment = Alignment.Center
        ) {
            AnimatedCard(
                isDarkTheme = isDarkTheme,
                textColor = textColor,
                onToggleTheme = { isDarkTheme = !isDarkTheme }
            )
        }
    }
}

@Composable
fun AnimatedCard(
    isDarkTheme: Boolean,
    textColor: Color,
    onToggleTheme: () -> Unit
) {

    var progress by remember { mutableStateOf(0.3f) }

    val animatedProgress by animateFloatAsState(progress)

    Card(
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(0.85f)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Material Animation Demo",
                style = MaterialTheme.typography.titleLarge,
                color = textColor
            )

            Spacer(modifier = Modifier.height(20.dp))

            LinearProgressIndicator(
                progress = animatedProgress,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                progress = if (progress >= 1f) 0.1f else progress + 0.2f
            }) {
                Text("Increase Progress")
            }

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedButton(onClick = onToggleTheme) {
                Text(if (isDarkTheme) "Switch to Light" else "Switch to Dark")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSession12() {
    Session12App()
}