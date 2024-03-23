package com.example.rickandmortyv2compose.features.navigation

sealed class Screens(val route: String) {
    data object Home : Screens("home_screen")
    data object ListOfCharacters : Screens("list_of_characters")
    data object ListOfEpisodes : Screens("list_of_episodes")
    data object ListOfLocations : Screens("list_of_locations")
    data object CharacterDetail : Screens("character_detail")
    data object EpisodeDetail : Screens("episode_detail")
    data object LocationDetail : Screens("location_detail")
}