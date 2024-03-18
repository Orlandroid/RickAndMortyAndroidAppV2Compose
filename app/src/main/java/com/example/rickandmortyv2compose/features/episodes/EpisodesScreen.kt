package com.example.rickandmortyv2compose.features.episodes

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.rickandmortyv2compose.R
import com.example.rickandmortyv2compose.features.base.BaseView
import com.example.rickandmortyv2compose.features.componets.ToolbarConfiguration
import com.example.rickandmortyv2compose.features.navigation.Screens
import com.example.rickandmortyv2compose.ui.theme.AlwaysWhite
import com.example.rickandmortyv2compose.ui.theme.Gris

@Composable
fun EpisodesScreen(navController: NavController) {
    val viewModel: EpisodesViewModel = hiltViewModel()
    BaseView(
        navController = navController, ToolbarConfiguration(
            isWithBackIcon = true, title = stringResource(id = R.string.episodes)
        )
    ) {
        Column(Modifier.verticalScroll(rememberScrollState())) {
            viewModel.getEpisodes().forEach {
                ItemEpisode(it) {
                    navController.navigate(Screens.EpisodeDetail.route)
                }
            }
        }
    }
}

@Composable
fun ItemEpisode(episode: Episode, clickOnItem: () -> Unit) {
    ConstraintLayout(
        Modifier
            .fillMaxWidth()
            .background(AlwaysWhite)
            .clickable {
                clickOnItem.invoke()
            }
    ) {
        val (layout, icon, spacer) = createRefs()
        Column(
            Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 8.dp, start = 16.dp)
                .constrainAs(layout) {
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(icon.start)
                }
        ) {
            Text(
                text = episode.episode, style =
                TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp)
            )
            Text(text = episode.name, fontSize = 16.sp)
            Text(text = episode.airDate, fontSize = 16.sp)
        }
        Icon(
            Icons.Default.PlayArrow,
            contentDescription = "",
            modifier = Modifier.constrainAs(icon) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end, 16.dp)
            }
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Gris)
                .constrainAs(spacer) {
                    top.linkTo(layout.bottom, 4.dp)
                    width = Dimension.fillToConstraints
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun EpisodesScreenPreview() {
    EpisodesScreen(rememberNavController())
}
