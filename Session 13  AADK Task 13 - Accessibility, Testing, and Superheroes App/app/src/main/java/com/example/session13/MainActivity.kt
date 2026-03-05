package com.example.session13

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroApp()
        }
    }
}

data class Superhero(
    val name: String,
    val alias: String,
    val power: String,
    val description: String
)

@Composable
fun SuperheroApp() {
    MaterialTheme {
        SuperheroListScreen()
    }
}

@Composable
fun SuperheroListScreen() {

    val heroes = listOf(
        Superhero("Clark Kent", "Superman", "Flight", "Clark Kent also known as Superman can fly."),
        Superhero("Diana Prince", "Wonder Woman", "Strength", "Diana Prince has superhuman strength."),
        Superhero("Bruce Wayne", "Batman", "Intelligence", "Batman uses intelligence and technology."),
        Superhero("Barry Allen", "Flash", "Speed", "Flash runs at incredible speed."),
        Superhero("Arthur Curry", "Aquaman", "Water Control", "Aquaman controls sea life.")
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        items(heroes) { hero ->
            HeroCard(hero)
        }
    }
}

@Composable
fun HeroCard(hero: Superhero) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .semantics {
                contentDescription =
                    "${hero.name}, also known as ${hero.alias}, power ${hero.power}"
            },
        elevation = CardDefaults.cardElevation(6.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = hero.alias,
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text("Real Name: ${hero.name}")
            Text("Power: ${hero.power}")

            Spacer(modifier = Modifier.height(6.dp))

            Text(hero.description)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSuperheroScreen() {
    SuperheroApp()
}