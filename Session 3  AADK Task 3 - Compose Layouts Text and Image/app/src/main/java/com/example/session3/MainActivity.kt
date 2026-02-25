package com.example.session3

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        // Banner Image
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "App banner image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Title Text
        Text(
            text = "Welcome to Jetpack Compose",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Description Text
        Text(
            text = "Jetpack Compose simplifies UI development by using declarative components. It helps build beautiful and responsive Android apps efficiently.",
            style = MaterialTheme.typography.bodyMedium
        )
        LinkText()
    }
}

@Composable
fun LinkText() {
    val uriHandler = LocalUriHandler.current

    Text(
        text = "Learn more about Compose",
        color = Color.Blue,
        modifier = Modifier.clickable {
            uriHandler.openUri("https://developer.android.com/jetpack/compose")
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewProfileScreen() {
    MaterialTheme {
        ProfileScreen()
    }
}