package com.example.rickandmortyv2compose.features.episodes

import androidx.lifecycle.ViewModel

class EpisodesViewModel : ViewModel() {
    private val charactersDummyProvider = EpisodesDummyProvider()
    fun getEpisodes() = charactersDummyProvider.getEpisodes()

    fun getRandomEpisode() = charactersDummyProvider.getEpisodes()[0]


}