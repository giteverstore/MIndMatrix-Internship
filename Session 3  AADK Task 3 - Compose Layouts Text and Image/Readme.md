# Session 3 - AADK Task 3: Compose Layouts (Text & Image)

## Overview
This project demonstrates how to build structured UI screens in Jetpack Compose using **Text** and **Image** composables.

The task focuses on layout planning, proper image resource handling, accessibility practices, and performance optimization while maintaining a clean and balanced UI design.

---

## Features Implemented

- Banner Image using `Image()`
- Styled Title and Description using `Text()`
- Proper spacing using `Spacer()`
- Material3 typography styling
- Accessibility using `contentDescription`
- Compose Preview support
- Clean layout hierarchy

---

## Layout Components Used

- **Column** → Vertical layout arrangement
- **Image** → Displays drawable resource
- **Text** → Displays styled text content
- **Spacer** → Manages vertical spacing

---

## Modifier Usage

- `fillMaxSize()`
- `fillMaxWidth()`
- `height()`
- `padding()`
- `clickable()` (if link extension is added)

---

## Image Resource Management

- Banner image stored in `res/drawable`
- Optimized image format (`.webp` recommended)
- Used `contentScale = ContentScale.Crop`
- Maintained proper aspect ratio

---

## Accessibility

- `contentDescription` added to Image
- Clear typography hierarchy
- Proper spacing for better readability
- Designed with screen-reader compatibility in mind

---

## Performance Considerations

- Lightweight drawable resource
- Minimal recomposition
- Clean composable structure
- Reusable UI components

---

## Learning Outcomes

- Understanding how Text and Image composables work together
- Designing visually balanced Compose layouts
- Applying accessibility best practices
- Managing image resources efficiently

---

## Author

**Avinash Abbigeri**
