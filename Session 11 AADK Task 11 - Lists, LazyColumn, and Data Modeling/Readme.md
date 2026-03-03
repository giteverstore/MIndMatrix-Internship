# Session 11 - AADK Task 11  
## Lists, LazyColumn, and Data Modeling

---

## 📌 Overview

This project demonstrates how to handle and display large datasets using Jetpack Compose.  
The application builds a scrollable student directory using `LazyColumn` and reusable card layouts.

This task focuses on dynamic list rendering and clean UI structuring using Compose best practices.

---

## 🎯 Objective

To build a scrollable UI that:

- Uses proper data modeling
- Displays dynamic content
- Implements reusable card components
- Follows Compose list rendering best practices

---

## 🧠 Key Concepts Covered

- Kotlin Data Classes
- Lists in Kotlin
- LazyColumn for efficient scrolling
- items() for dynamic list binding
- Card composable for structured UI
- Separation of UI components

---

## 🏗️ Data Model

A `Student` data class represents each list item:

```kotlin
data class Student(
    val name: String,
    val course: String,
    val year: Int
)
