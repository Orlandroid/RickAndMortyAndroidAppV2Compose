package com.example.rickandmortyv2compose.features.locations

import androidx.lifecycle.ViewModel

class LocationsViewModel : ViewModel() {

    private val locationDummyProvider = LocationsDummyProvider()

    fun getLocations() = locationDummyProvider.getLocations()

    fun getRandomLocation() = locationDummyProvider.getLocations()[0]
}