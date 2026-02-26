# Session 8 - AADK Task 8: UI Testing and Art Navigation

## 📌 Overview

This project demonstrates a multi-screen Art Gallery built using Jetpack Compose.

The application allows users to navigate through artworks using **Next** and **Previous** buttons while dynamically updating the UI.

This task introduces structured UI state and lays the foundation for UI testing.

---

## 🎯 Objective

To build a state-driven art viewer that:

- Displays artwork details
- Supports navigation between artworks
- Updates UI based on user interaction
- Maintains state across configuration changes

---

## 🧠 Key Concepts Covered

| Concept | Description |
|----------|-------------|
| Structured UI State | Artwork index controls screen content |
| rememberSaveable | Preserves state on rotation |
| Recomposition | UI updates automatically |
| Navigation Logic | Next / Previous actions |
| Data Modeling | Artwork data class |

---

## 🧱 App Structure

### Artwork Data Model

Each artwork includes:

- Title
- Artist
- Year

```kotlin
data class Artwork(
    val title: String,
    val artist: String,
    val year: Int
)
