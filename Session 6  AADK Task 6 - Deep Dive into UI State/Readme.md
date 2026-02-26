# Session 6 - AADK Task 6: Deep Dive into UI State

## 📌 Overview

This project demonstrates structured UI state management in Jetpack Compose.

The application showcases how UI can dynamically adapt to:

- User interaction
- Screen navigation
- Configuration changes (device rotation)

This task builds confidence in managing multi-element, reactive interfaces.

---

## 🎯 Objective

To understand how structured state controls:

- Screen transitions
- UI updates
- Component interaction
- State persistence across configuration changes

---

## 🧠 Key Concepts Covered

| Concept | Description |
|----------|-------------|
| Structured State | Using enum to control screens |
| State Hoisting | Passing navigation lambdas |
| rememberSaveable | Preserves state on rotation |
| Recomposition | UI updates automatically |
| Multi-Element UI | Counter + Toggle + Navigation |

---

## 🧱 App Structure

The app contains two screens:

### 1️⃣ Home Screen
- Counter display
- Increment button
- Enable/Disable toggle
- Navigation button to Details screen

### 2️⃣ Details Screen
- Informational text
- Back button to Home

Screen switching is handled using structured state:

```kotlin
enum class Screen {
    HOME,
    DETAILS
}
