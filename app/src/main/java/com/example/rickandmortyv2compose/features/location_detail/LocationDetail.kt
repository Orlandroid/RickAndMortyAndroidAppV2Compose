package com.example.rickandmortyv2compose.features.location_detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.rickandmortyv2compose.R
import com.example.rickandmortyv2compose.features.base.BaseView
import com.example.rickandmortyv2compose.features.characters.CharactersViewModel
import com.example.rickandmortyv2compose.features.characters.ItemCharacter
import com.example.rickandmortyv2compose.features.componets.ToolbarConfiguration


@Composable
fun LocationDetail(navController: NavController) {
    val charactersViewModel: CharactersViewModel = hiltViewModel()
    BaseView(
        navController = navController, ToolbarConfiguration(
            isWithBackIcon = true, title = stringResource(id = R.string.locations)
        )
    ) {
        Column(
            Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Microverse", fontSize = 16.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Anatomy park",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            charactersViewModel.getCharacters().forEach {
                ItemCharacter(
                    character = it, colorStatus = Color.Green
                ) {

                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun LocationDetailPreview() {
    LocationDetail(rememberNavController())
}