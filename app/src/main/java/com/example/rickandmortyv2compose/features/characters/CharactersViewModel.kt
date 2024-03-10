package com.example.rickandmortyv2compose.features.characters

import androidx.lifecycle.ViewModel

class CharactersViewModel : ViewModel() {
    private val charactersDummyProvider = CharactersDummyProvider()
    fun getCharacters() = charactersDummyProvider.getCharacters()

}