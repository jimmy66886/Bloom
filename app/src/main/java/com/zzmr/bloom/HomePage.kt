package com.zzmr.bloom

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.zzmr.bloom.ui.theme.body1
import com.zzmr.bloom.ui.theme.caption
import com.zzmr.bloom.ui.theme.gray
import com.zzmr.bloom.ui.theme.h1
import com.zzmr.bloom.ui.theme.h2
import com.zzmr.bloom.ui.theme.pink100
import com.zzmr.bloom.ui.theme.white

@Composable
fun HomePage() {
    Scaffold(
        bottomBar = {
            BottomBar()
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(white)
                .padding(contentPadding) // 使用 contentPadding
                .padding(16.dp) // 额外的内边距
        ) {
            SearchBar()
            BloomRowBanner()
            BloomInfoList()
        }
    }
}

data class ImageItem(val name: String, val resId: Int)

val bloomBannerList = listOf<ImageItem>(
    ImageItem("Desert chic", R.mipmap.desert_chic),
    ImageItem("Tiny terrariums", R.mipmap.tiny_terrariums),
    ImageItem("Jungle Vibes", R.mipmap.jungle_vibes)
)

val bloomInfoList = listOf<ImageItem>(
    ImageItem("Monstera", R.mipmap.monstera),
    ImageItem("Aglaonema", R.mipmap.aglaonema),
    ImageItem("Peace lily", R.mipmap.peace_lily),
    ImageItem("Fiddle leaf tree", R.mipmap.fiddle_leaf),
    ImageItem("Desert chic", R.mipmap.desert_chic),
    ImageItem("Tiny terrariums", R.mipmap.tiny_terrariums),
    ImageItem("Jungle Vibes", R.mipmap.jungle_vibes)
)

val navList = listOf<ImageItem>(
    ImageItem("Home", R.drawable.ic_home),
    ImageItem("Favorites", R.drawable.ic_favorite_border),
    ImageItem("Profile", R.drawable.ic_account_circle),
    ImageItem("Cart", R.drawable.ic_shopping_cart),
)

@Composable
fun BottomBar() {
    var selectedItem by remember { mutableStateOf("") }
    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(pink100)
    ) {
        navList.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItem == item.name,
                onClick = {
                    selectedItem = item.name
                },
                icon = {
                    Icon(
                        painterResource(id = item.resId),
                        null,
                        Modifier.size(24.dp)
                    )
                },
                label = {
                    Text(item.name, style = caption, color = gray)
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    var searchValue = remember { mutableStateOf("") }
    Box {
        TextField(
            value = searchValue.value,
            onValueChange = {
                searchValue.value = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .clip(RoundedCornerShape(4.dp))
                .border(BorderStroke(1.dp, Color.Black))
                .background(white),
            leadingIcon = {
                Icon(
                    Icons.Filled.Search,
                    contentDescription = "search",
                    modifier = Modifier.size(18.dp)
                )
            },
            placeholder = {
                Text(
                    text = "Search",
                    style = body1,
                    color = gray
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = white,
                focusedBorderColor = white
            )
        )
    }
}

@Composable
fun PlantCard(plant: ImageItem) {
    Card(
        modifier = Modifier
            .size(136.dp)
            .clip(RoundedCornerShape(4.dp))
    ) {
        Column {
            Image(
                painterResource(id = plant.resId),
                contentDescription = "image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(96.dp)
            )
            Box(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp)
            ) {
                Text(
                    text = plant.name,
                    style = h2,
                    color = gray,
                    modifier = Modifier
                        .fillMaxWidth()
                        .paddingFromBaseline(top = 24.dp, bottom = 16.dp)
                )
            }
        }
    }
}

@Composable
fun BloomRowBanner() {
    Column {
        Box(Modifier.fillMaxWidth()) {
            Text(
                text = "Browse themes",
                style = h1,
                color = gray,
                modifier = Modifier.paddingFromBaseline(top = 32.dp)
            )
        }
        Spacer(Modifier.height(16.dp))
        LazyRow(
            Modifier.height(136.dp)
        ) {
            items(bloomBannerList.size) {
                if (it != 0) {
                    // 每个子元素间水平间距为8dp
                    Spacer(Modifier.width(8.dp))
                }
                PlantCard(bloomBannerList[it])
            }
        }
    }
}

@Composable
fun DesignCard(plant: ImageItem) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Image(
            painterResource(id = plant.resId),
            contentScale = ContentScale.Crop,
            contentDescription = "image",
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(4.dp))
        )
        Spacer(Modifier.width(16.dp))
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = plant.name,
                        style = h2,
                        color = gray,
                        modifier = Modifier.paddingFromBaseline(top = 24.dp)
                    )
                    Text(
                        text = "This is a description",
                        style = body1,
                        color = gray,
                    )
                }
                Checkbox(
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .size(24.dp),
                    checked = false,
                    onCheckedChange = {},
                    colors = CheckboxDefaults.colors(checkmarkColor = white)
                )
            }
            // 每个子元素底部都有的下划线
            HorizontalDivider(
                color = gray,
                modifier = Modifier.padding(top = 16.dp),
                thickness = 0.5.dp
            )
        }
    }
}

@Composable
fun BloomInfoList() {
    Column {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Design your home garden",
                style = h1,
                color = gray,
                modifier = Modifier.paddingFromBaseline(top = 40.dp)
            )
            Icon(
                Icons.Filled.List,
                "filter",
                modifier = Modifier
                    .padding(top = 24.dp)
                    .size(24.dp)
            )
        }
        Spacer(Modifier.height(16.dp))
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(bottom = 56.dp)
        ) {
            items(bloomInfoList.size) {
                if (it != 0) {
                    Spacer(Modifier.height(8.dp))
                }
                DesignCard(bloomInfoList[it])
            }
        }
    }
}