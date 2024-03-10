package com.example.rickandmortyv2compose.features.characters

class CharactersDummyProvider {
    fun getCharacters(): List<Character> {
        return listOf(
            Character(),
            Character(),
            Character(),
            Character(),
            Character(),
            Character(),
            Character(),
            Character(),
            Character(),
            Character()
        )
    }
}

data class Character(
    val status: String = "Alive",
    val name: String = "Rick Sanchez",
    val species: String = "Human",
    val image: String = "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
)