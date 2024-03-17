package com.example.rickandmortyv2compose.features.base

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.rickandmortyv2compose.features.componets.Toolbar
import com.example.rickandmortyv2compose.features.componets.ToolbarConfiguration
import com.example.rickandmortyv2compose.ui.theme.Background


@Composable
fun BaseView(
    navController: NavController,
    toolbarConfiguration: ToolbarConfiguration = ToolbarConfiguration(),
    background: Color = Background,
    content: @Composable () -> Unit
) {
    Scaffold(
        topBar = {
            if (toolbarConfiguration.isWithBackIcon) {
                Toolbar(
                    navController = navController, toolbarConfiguration
                )
            }
        }
    ) { paddingValues ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(background)
        ) {
            content()
        }
    }
}


@Composable
@Preview(showBackground = true)
fun BaseViewPreview() {
    BaseView(navController = rememberNavController()) {
        Text(text = "I am just trying to be my best software engineer version")
    }
}