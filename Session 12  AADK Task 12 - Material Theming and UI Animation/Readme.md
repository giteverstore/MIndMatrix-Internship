# Session 12 - AADK Task 12  
## Material Theming and UI Animation

---

## 📌 Overview

This project demonstrates how to create polished Android applications using Jetpack Compose Material 3 components and Animation APIs.

The application includes dynamic theme switching (Light/Dark mode) and animated UI elements such as color transitions and progress indicators.

This task highlights how theming and motion improve usability and visual appeal.

---

## 🎯 Objective

To build a Compose application that:

- Applies custom Material theming
- Animates UI state changes
- Uses animation APIs for smooth transitions
- Improves visual polish using shapes, elevation, and spacing

---

## 🧠 Key Concepts Covered

- MaterialTheme customization
- Typography styling
- Custom shapes using RoundedCornerShape
- animateColorAsState for theme transitions
- animateFloatAsState for progress animation
- State management with mutableStateOf
- Recomposition and animated state updates

---

## 🏗️ App Structure

### 1️⃣ Theme Toggle

The app uses a Boolean state (`isDarkTheme`) to switch between light and dark modes.  
Color changes are animated using:

```kotlin
animateColorAsState(...)
