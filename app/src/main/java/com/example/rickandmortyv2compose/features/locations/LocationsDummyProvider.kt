package com.example.rickandmortyv2compose.features.locations

class LocationsDummyProvider {
    fun getLocations(): List<Location> {
        return listOf(
            Location(),
            Location(name = "Abadango", type = "Cluster"),
            Location(name = "Citadel of Ricks", type = "Space station"),
            Location(name = "Worldender's lair", type = "Planet"),
            Location(name = "Anatomy Park", type = "Microverse"),
            Location(),
            Location(name = "Abadango", type = "Cluster"),
            Location(name = "Citadel of Ricks", type = "Space station"),
            Location(name = "Worldender's lair", type = "Planet"),
            Location(name = "Anatomy Park", type = "Microverse"),
            Location(),
            Location(name = "Abadango", type = "Cluster"),
            Location(name = "Citadel of Ricks", type = "Space station"),
            Location(name = "Worldender's lair", type = "Planet"),
            Location(name = "Anatomy Park", type = "Microverse"),
            Location()
        )
    }
}


data class Location(
    val name: String = "Earth (C-137)", val type: String = "Planet"
)