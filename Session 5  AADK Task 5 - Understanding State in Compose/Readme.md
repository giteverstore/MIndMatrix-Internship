# Session 5 - AADK Task 5: Understanding State in Compose

## 📌 Overview

This project demonstrates how **state management** works in Jetpack Compose and how it enables real-time UI updates.

The application captures user input and updates the UI dynamically, helping understand:

- State handling
- Recomposition
- Reactive UI behavior

---

## 🎯 Objective

To understand how Compose manages UI updates using state and how user input can be reflected instantly without manual refresh.

---

## 🧠 Key Concepts Covered

| Concept | Description |
|--------|-------------|
| State | Stores dynamic UI data |
| remember | Preserves state across recompositions |
| mutableStateOf | Creates observable state |
| Recomposition | UI updates when state changes |
| Reactive UI | UI reacts automatically to user input |

---

## 🛠 Implementation

The application contains:

- A text input field
- A greeting message

As the user types their name, the greeting updates instantly.

Example:

Input: `Avi`  
Output: `Hello, Avi!`

This behavior demonstrates real-time recomposition.

---

## 🔄 How It Works

1. User enters text into the input field.
2. The value is stored using `mutableStateOf`.
3. Compose detects the state change.
4. The UI recomposes automatically.
5. The greeting updates instantly.

No manual UI refresh is required.

---

## 📱 UI Components Used

- Column layout
- OutlinedTextField
- Text
- Spacer
- Material3 Theme

---

## 🧪 Compose State Used

```kotlin
var name by remember { mutableStateOf("") }
