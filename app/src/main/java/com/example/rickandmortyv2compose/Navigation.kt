package com.example.rickandmortyv2compose

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rickandmortyv2compose.features.Screens
import com.example.rickandmortyv2compose.features.characters.CharactersScreen
import com.example.rickandmortyv2compose.features.home.HomeScreen


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.Home.route) {
        composable(route = Screens.Home.route) {
            HomeScreen(navController)
        }
        composable(route = Screens.ListOfCharacters.route) {
            CharactersScreen(navController)
        }
    }
}