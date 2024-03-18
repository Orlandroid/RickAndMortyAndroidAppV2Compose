package com.example.rickandmortyv2compose.features.character_detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
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
import com.example.rickandmortyv2compose.features.characters.CharactersViewModel
import com.example.rickandmortyv2compose.features.componets.ItemKeyValue
import com.example.rickandmortyv2compose.features.componets.ToolbarConfiguration

@Composable
fun CharacterDetail(navController: NavController) {
    val viewModel: CharactersViewModel = hiltViewModel()
    val character = viewModel.getRandomCharacter()
    BaseView(
        navController = navController,
        ToolbarConfiguration(
            isWithBackIcon = true,
            title = character.name,
            toolbarBackgroundColor = Color.Red,
        )
    ) {
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
                    .clip(RoundedCornerShape(topEnd = 12.dp, topStart = 8.dp))
                    .layoutId(imageId)
            )
            Column(
                modifier = Modifier
                    .layoutId(cardInfoUserId)
            ) {
                ItemsTextWithValue(
                    layoutId = cardInfoUserId,
                    myItems = ItemEntity(
                        characterItem = getPropertiesCharacter()
                    )
                )
                Spacer(modifier = Modifier.size(16.dp))
                ItemsTextWithValue(
                    layoutId = "",
                    myItems = ItemEntity(
                        characterItem = getPropertiesLocation(),
                        hasHeader = Pair(true, "Last seen location")
                    )
                )
            }
        }
    }
}

private fun getPropertiesCharacter() =
    listOf(
        Property("Status", "Alive"),
        Property("Species", "Human"),
        Property("Gender", "Male"),
        Property("Number of episodes", "15")
    )


private fun getPropertiesLocation() =
    listOf(
        Property("Name", "Citadel of ricks"),
        Property("Type", "Space tation"),
        Property("Dimension", "Unknowkn"),
        Property("Number of residents", "101")
    )


@Composable
fun ItemsTextWithValue(myItems: ItemEntity, layoutId: String) {
    Card(
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(2.dp, Color.Red),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .layoutId(layoutId)
            .padding(horizontal = 8.dp)
            .wrapContentHeight()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp, bottom = 8.dp)
        ) {
            if (myItems.hasHeader.first) {
                Text(
                    text = myItems.hasHeader.second,
                    style = TextStyle(fontSize = 26.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
            myItems.let { items ->
                for (currentItem in items.characterItem.indices) {
                    ItemKeyValue(
                        key = items.characterItem[currentItem].key,
                        value = items.characterItem[currentItem].value
                    )
                }
            }
        }
    }

}

data class ItemEntity(
    val characterItem: List<Property>,
    val hasHeader: Pair<Boolean, String> = Pair(false, "")
)

data class Property(
    val key: String,
    val value: String
)


@Composable
@Preview(showBackground = true)
fun CharacterDetailPreview() {
    CharacterDetail(navController = rememberNavController())
}
