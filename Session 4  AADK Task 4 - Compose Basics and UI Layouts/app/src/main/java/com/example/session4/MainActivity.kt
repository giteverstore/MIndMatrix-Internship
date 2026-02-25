package com.example.session4

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun BusinessCardScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        // 🔴 TOP SECTION (Logo + Name + Title)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {

            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = "Profile Logo",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(120.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Full Name",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Title",
                style = MaterialTheme.typography.bodyLarge
            )
        }

        // 🔴 BOTTOM CONTACT SECTION
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            ContactRow(
                icon = Icons.Default.Phone,
                text = "+00 (00) 000 000"
            )

            ContactRow(
                icon = Icons.Default.Share,
                text = "@socialmediahandle"
            )

            ContactRow(
                icon = Icons.Default.Email,
                text = "email@domain.com"
            )
        }
    }
}

@Composable
fun ContactRow(icon: ImageVector, text: String) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = icon,
            contentDescription = null
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBusinessCard() {
    MaterialTheme {
        BusinessCardScreen()
    }
}