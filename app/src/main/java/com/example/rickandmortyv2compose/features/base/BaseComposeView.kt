package com.example.rickandmortyv2compose.features.base

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.rickandmortyv2compose.features.componets.Toolbar
import com.example.rickandmortyv2compose.features.componets.ToolbarConfiguration


@Composable
fun BaseView(
    navController: NavController,
    toolbarConfiguration: ToolbarConfiguration = ToolbarConfiguration(),
    content: @Composable () -> Unit
) {
    Column {
        if (toolbarConfiguration.isWithBackIcon) {
            Toolbar(
                navController = navController, toolbarConfiguration
            )
        }
        content()
    }
}