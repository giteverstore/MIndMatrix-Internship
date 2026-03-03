package com.example.session10

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Session10App()
        }
    }
}

// 1️⃣ Kotlin Class
data class Product(
    val name: String,
    val price: Double
)

// 2️⃣ Object (Singleton utility)
object DiscountManager {
    fun applyDiscount(price: Double, discount: (Double) -> Double): Double {
        return discount(price)
    }
}

@Composable
fun Session10App() {
    MaterialTheme {
        ProductScreen()
    }
}

@Composable
fun ProductScreen() {

    val product = Product("Laptop", 100000.0)

    var discountedPrice by remember { mutableStateOf(product.price) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text("Product: ${product.name}", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(20.dp))

        Text("Original Price: ₹${product.price}")

        Spacer(modifier = Modifier.height(10.dp))

        Text("Discounted Price: ₹$discountedPrice")

        Spacer(modifier = Modifier.height(30.dp))

        // 3️⃣ Lambda passed as parameter
        Button(
            onClick = {
                discountedPrice = DiscountManager.applyDiscount(product.price) { price ->
                    price * 0.9  // 10% discount
                }
            }
        ) {
            Text("Apply 10% Discount")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSession10() {
    Session10App()
}