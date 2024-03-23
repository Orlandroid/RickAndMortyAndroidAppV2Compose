package com.example.rickandmortyv2compose.features.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rickandmortyv2compose.features.character_detail.CharacterDetail
import com.example.rickandmortyv2compose.features.characters.CharactersScreen
import com.example.rickandmortyv2compose.features.episode_detail.EpisodeDetailScreen
import com.example.rickandmortyv2compose.features.episodes.EpisodesScreen
import com.example.rickandmortyv2compose.features.home.HomeScreen
import com.example.rickandmortyv2compose.features.location_detail.LocationDetail
import com.example.rickandmortyv2compose.features.locations.LocationsScreen


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
        composable(route = Screens.CharacterDetail.route) {
            CharacterDetail(navController = navController)
        }
        composable(route = Screens.ListOfEpisodes.route) {
            EpisodesScreen(navController)
        }
        composable(route = Screens.EpisodeDetail.route) {
            EpisodeDetailScreen(navController)
        }
        composable(route = Screens.ListOfLocations.route) {
            LocationsScreen(navController)
        }
        composable(route = Screens.LocationDetail.route) {
            LocationDetail(navController)
        }
    }
}