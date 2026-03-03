package com.example.session11

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Session11App()
        }
    }
}

// 1️⃣ Data Model
data class Student(
    val name: String,
    val course: String,
    val year: Int
)

@Composable
fun Session11App() {
    MaterialTheme {
        StudentListScreen()
    }
}

@Composable
fun StudentListScreen() {

    val students = listOf(
        Student("Avi", "Computer Science", 3),
        Student("Riya", "Information Technology", 2),
        Student("Karan", "Electronics", 4),
        Student("Meera", "Mechanical", 1),
        Student("Rahul", "Civil Engineering", 3),
        Student("Ananya", "Data Science", 2),
        Student("Vikram", "AI & ML", 4)
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(students) { student ->
            StudentCard(student)
        }
    }
}

@Composable
fun StudentCard(student: Student) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = student.name,
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text("Course: ${student.course}")
            Text("Year: ${student.year}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewStudentList() {
    Session11App()
}