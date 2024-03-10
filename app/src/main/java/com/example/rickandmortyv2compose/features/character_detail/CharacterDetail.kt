package com.example.rickandmortyv2compose.features.character_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.rickandmortyv2compose.features.base.BaseView
import com.example.rickandmortyv2compose.features.base.BaseViewContent
import com.example.rickandmortyv2compose.features.characters.CharactersViewModel

@Composable
fun CharacterDetail(navController: NavController) {
    val viewModel: CharactersViewModel = hiltViewModel()
    val character = viewModel.getRandomCharacter()
    val myBaseViewContent = BaseViewContent(isWithBackIcon = true, title = character.name)
    BaseView(navController = navController, baseViewContent = myBaseViewContent) {
        val imageId = "imageId"
        val cardInfoUserId = "cardInfoUser"
        val constraint = ConstraintSet {
            val image = createRefFor(imageId)
            val cardInfoUser = createRefFor(cardInfoUserId)
            constrain(image) {
                top.linkTo(parent.top, 10.dp)
                end.linkTo(parent.end)
                start.linkTo(parent.start)
                width = Dimension.matchParent
                height = Dimension.value(200.dp)
            }
            constrain(cardInfoUser) {
                top.linkTo(image.bottom, 16.dp)
                end.linkTo(parent.end)
                start.linkTo(parent.start)
                width = Dimension.matchParent
            }
        }
        ConstraintLayout(constraintSet = constraint, modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = character.image,
                contentDescription = "",
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(50))
                    .size(48.dp)
                    .layoutId(imageId)
            )
            Card(
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                modifier = Modifier
                    .layoutId(cardInfoUserId)
                    .padding(horizontal = 8.dp)
                    .wrapContentHeight()
            ) {
                ItemTextWithValue(key = "Status:", value = "Alive")
                ItemTextWithValue(key = "Species:", value = "Human")
                ItemTextWithValue(key = "Gender:", value = "Male")
                ItemTextWithValue(
                    key = "Number of episodes:",
                    value = "15",
                )
            }

        }
    }
}

@Composable
fun ItemTextWithValue(key: String, value: String) {
    Row(Modifier.padding(start = 32.dp, top = 16.dp)) {
        Text(
            text = key,
            fontSize = 24.sp,
        )
        Spacer(
            modifier = Modifier
                .size(24.dp)
        )
        Text(
            text = value,
            fontSize = 24.sp,
        )
    }
}


@Composable
@Preview(showBackground = true)
fun CharacterDetailPreview() {
    CharacterDetail(navController = rememberNavController())
}
