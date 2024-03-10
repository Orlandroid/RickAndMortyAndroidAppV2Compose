package com.example.rickandmortyv2compose.features.base

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.rickandmortyv2compose.features.componets.Toolbar


@Composable
fun BaseView(
    navController: NavController,
    baseViewContent: BaseViewContent = BaseViewContent(),
    content: @Composable () -> Unit
) {
    Column {
        if (baseViewContent.isWithBackIcon) {
            Toolbar(
                navController = navController, title = baseViewContent.title
            )
        }
        content()
    }
}

data class BaseViewContent(
    val isWithBackIcon: Boolean = true,
    val title: String = ""
)