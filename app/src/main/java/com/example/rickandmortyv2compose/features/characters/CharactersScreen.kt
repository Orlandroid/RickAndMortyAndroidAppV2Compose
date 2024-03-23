package com.example.rickandmortyv2compose.features.characters

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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

@Composable
fun CharactersScreen(navController: NavController) {
    val viewModel: CharactersViewModel = hiltViewModel()
    BaseView(
        navController = navController, ToolbarConfiguration(
            isWithBackIcon = true, title = stringResource(id = R.string.characters)
        )
    ) {
        LazyColumn {
            viewModel.getCharacters().forEach {
                item {
                    ItemCharacter(
                        character = it, colorStatus = Color.Green
                    ) {
                        navController.navigate(Screens.CharacterDetail.route)
                    }
                }
            }
        }
    }
}


@Composable
fun ItemCharacter(
    character: Character,
    colorStatus: Color,
    clickOnCharacter: () -> Unit = {}
) {
    Card(
        onClick = { clickOnCharacter.invoke() },
        border = BorderStroke(2.dp, Color.Black),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.padding(top = 8.dp, start = 8.dp, end = 8.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .height(100.dp)
                .background(Color.White)
                .fillMaxWidth()
        ) {
            val (refImageCharacter, refTextCharacter, refImageStatus, refTextStatus, refTextSpecie, refTextSeparator) = createRefs()
            val charactersImage = painterResource(id = R.drawable.rick_and_morty)
            Image(painter = charactersImage,
                contentDescription = null,
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                    .constrainAs(refImageCharacter) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    })
            Text(
                fontSize = 24.sp,
                text = character.name,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.constrainAs(refTextCharacter) {
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                    top.linkTo(parent.top)
                    start.linkTo(refImageCharacter.end)
                    end.linkTo(parent.end)
                },
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier
                    .padding(top = 32.dp)
                    .constrainAs(refImageStatus) {
                        top.linkTo(refTextCharacter.bottom)
                        start.linkTo(refImageCharacter.end)
                    }
                    .size(16.dp)
                    .drawBehind {
                        drawCircle(
                            color = colorStatus, radius = 16f
                        )
                    },
                text = "",
            )
            Text(
                fontSize = 18.sp,
                text = character.status,
                modifier = Modifier
                    .padding(start = 16.dp, top = 0.dp)
                    .constrainAs(refTextStatus) {
                        start.linkTo(refImageStatus.end)
                        bottom.linkTo(refImageStatus.bottom)
                    },
                textAlign = TextAlign.Center,
            )
            Text(
                fontSize = 18.sp,
                text = "-",
                modifier = Modifier
                    .padding(start = 16.dp, top = 0.dp)
                    .constrainAs(refTextSeparator) {
                        start.linkTo(refTextStatus.end)
                        bottom.linkTo(refTextStatus.bottom)
                    },
                textAlign = TextAlign.Center,
            )
            Text(
                fontSize = 18.sp,
                text = "Human",
                modifier = Modifier
                    .padding(start = 16.dp, top = 0.dp)
                    .constrainAs(refTextSpecie) {
                        start.linkTo(refTextSeparator.end)
                        bottom.linkTo(refTextSeparator.bottom)
                    },
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SimpleComposablePreview() {
    CharactersScreen(rememberNavController())
}