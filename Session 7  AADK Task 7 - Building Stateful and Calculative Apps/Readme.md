# Session 7 - AADK Task 7: Building Stateful and Calculative Apps

## 📌 Overview

This project demonstrates how structured data flow connects user input with UI updates in Jetpack Compose.

The application is a Tip Calculator that dynamically updates results based on:

- Text input
- Slider selection
- Switch toggle

It highlights how UI state drives logic and real-time computation.

---

## 🎯 Objective

To build a stateful application that combines:

- User input
- Interactive UI controls
- Validation
- Real-time calculations

---

## 🧠 Key Concepts Covered

| Concept | Description |
|----------|-------------|
| State Management | Using rememberSaveable |
| Structured Data Flow | Connecting input → logic → output |
| Recomposition | UI updates automatically |
| Input Validation | Safe numeric conversion |
| Real-time Calculation | Tip updates instantly |

---

## 🧱 App Structure

The Tip Calculator includes:

### 1️⃣ Bill Amount Input
Users enter bill value using a text field.

### 2️⃣ Tip Percentage Slider
Allows selecting tip between 0% and 30%.

### 3️⃣ Round-Up Switch
Users can enable rounding for the tip amount.

### 4️⃣ Calculated Tip Output
Displays tip dynamically based on selected values.

---

## 🔄 Data Flow

The UI reacts instantly using structured state:

```kotlin
var billAmount by rememberSaveable { mutableStateOf("") }
var tipPercent by rememberSaveable { mutableStateOf(15f) }
var roundUp by rememberSaveable { mutableStateOf(false) }
