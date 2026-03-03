# Session 10 - AADK Task 10  
## Kotlin Classes, Objects, and Lambdas

---

## 📌 Overview

This project demonstrates core Kotlin concepts including classes, objects, and higher-order functions using Jetpack Compose.  
The application simulates a simple product discount system where a discount is applied dynamically using a lambda function.

This task strengthens understanding of clean code structure, modular logic, and reusable components.

---

## 🎯 Objective

To build a small Compose-based app that:

- Uses Kotlin data classes
- Implements a singleton object
- Passes lambda functions as parameters
- Updates UI using state

---

## 🧠 Key Concepts Covered

- Kotlin `data class`
- Kotlin `object` (Singleton pattern)
- Higher-order functions
- Lambda expressions
- State management with `mutableStateOf`
- UI recomposition in Jetpack Compose

---

## 🏗️ App Structure

### 1️⃣ Product Class

A `Product` data class represents a simple product with:

- Name
- Price

```kotlin
data class Product(
    val name: String,
    val price: Double
)
