package com.example.session7

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
import kotlin.math.ceil

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipCalculatorApp()
        }
    }
}

@Composable
fun TipCalculatorApp() {
    MaterialTheme {
        TipCalculatorScreen()
    }
}

@Composable
fun TipCalculatorScreen() {

    var billAmount by rememberSaveable { mutableStateOf("") }
    var tipPercent by rememberSaveable { mutableStateOf(15f) }
    var roundUp by rememberSaveable { mutableStateOf(false) }

    val amount = billAmount.toDoubleOrNull() ?: 0.0

    val tip = calculateTip(amount, tipPercent.toInt(), roundUp)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Tip Calculator",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Bill Input
        OutlinedTextField(
            value = billAmount,
            onValueChange = { billAmount = it },
            label = { Text("Enter Bill Amount") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Tip Slider
        Text("Tip: ${tipPercent.toInt()}%")

        Slider(
            value = tipPercent,
            onValueChange = { tipPercent = it },
            valueRange = 0f..30f
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Round up switch
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Round Up Tip")

            Spacer(modifier = Modifier.width(10.dp))

            Switch(
                checked = roundUp,
                onCheckedChange = { roundUp = it }
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Tip Amount: ₹${"%.2f".format(tip)}",
            style = MaterialTheme.typography.headlineSmall
        )
    }
}

fun calculateTip(amount: Double, tipPercent: Int, roundUp: Boolean): Double {

    var tip = amount * tipPercent / 100.0

    if (roundUp) {
        tip = ceil(tip)
    }

    return tip
}

@Preview(showBackground = true)
@Composable
fun PreviewTipCalculator() {
    TipCalculatorApp()
}