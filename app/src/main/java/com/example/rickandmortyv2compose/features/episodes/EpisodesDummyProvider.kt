package com.example.rickandmortyv2compose.features.episodes

class EpisodesDummyProvider {
    fun getEpisodes(): List<Episode> {
        return listOf(
            Episode(),
            Episode(episode = "S01E02", airDate = "December 9, 2013", name = "Lawnmower Dog"),
            Episode(episode = "S01E03", airDate = "December 9, 2013", name = "Anatomy Park"),
            Episode(episode = "S01E04", airDate = "December 9, 2013", name = "Lawnmower Dog"),
            Episode(episode = "S01E05", airDate = "December 9, 2013", name = "Lawnmower Dog"),
            Episode(episode = "S01E06", airDate = "December 9, 2013", name = "Lawnmower Dog"),
            Episode(episode = "S01E07", airDate = "December 9, 2013", name = "Lawnmower Dog"),
            Episode(episode = "S01E08", airDate = "December 9, 2013", name = "Lawnmower Dog"),
            Episode(episode = "S01E09", airDate = "December 9, 2013", name = "Lawnmower Dog"),
            Episode(episode = "S01E010", airDate = "December 9, 2013", name = "Lawnmower Dog"),
        )
    }
}


data class Episode(
    val airDate: String = "December 2, 2013",
    val episode: String = "S01E01",
    val name: String = "Pilot"
)