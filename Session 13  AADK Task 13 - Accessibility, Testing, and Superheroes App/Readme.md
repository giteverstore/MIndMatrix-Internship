# Session 13 - AADK Task 13
## Accessibility, Testing, and Superheroes App

---

## Overview

This project demonstrates how to build accessible Android applications using Jetpack Compose. The application displays a list of superheroes and focuses on improving usability through semantic properties that support screen readers such as TalkBack.

The app also follows Compose best practices for rendering lists, structuring UI components, and preparing the application for UI testing.

---

## Objective

The goal of this task is to create a superhero catalog that:

- Displays dynamic content using LazyColumn
- Uses semantic properties for accessibility
- Structures UI with reusable composable functions
- Prepares the app for UI testing

---

## Key Concepts Covered

- Accessibility using semantic properties
- Screen reader friendly design
- Kotlin data classes for data modeling
- LazyColumn for efficient list rendering
- Reusable composable components
- Material3 UI components
- UI structure suitable for testing

---

## Data Model

A simple data class represents each superhero.

```kotlin
data class Superhero(
    val name: String,
    val alias: String,
    val power: String,
    val description: String
)
