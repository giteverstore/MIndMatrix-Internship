package com.avinash.convertly.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    selectedFile: String?,
    fileCategory: String?,
    onSelectFile: () -> Unit,
    onConvert: (String) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Convertly",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = onSelectFile) {
            Text("Select File")
        }

        Spacer(modifier = Modifier.height(24.dp))

        selectedFile?.let {
            Text("Selected: $it")
        }

        Spacer(modifier = Modifier.height(16.dp))

        fileCategory?.let { category ->

            Text("Convert To")

            Spacer(modifier = Modifier.height(12.dp))

            when (category) {

                "image" -> {

                    Button(onClick = { onConvert("png") }) {
                        Text("PNG")
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(onClick = { onConvert("jpg") }) {
                        Text("JPG")
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(onClick = { onConvert("webp") }) {
                        Text("WEBP")
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(onClick = { onConvert("pdf") }) {
                        Text("PDF")
                    }
                }

                "pdf" -> {

                    Button(onClick = { onConvert("image_from_pdf") }) {
                        Text("Image")
                    }

                }

                "excel" -> {
                    Button(onClick = {}) { Text("CSV") }
                }

                "csv" -> {
                    Button(onClick = {}) { Text("Excel") }
                }

                "word" -> {
                    Button(onClick = {}) { Text("TXT") }
                }

            }

        }

    }
}