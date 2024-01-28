package com.sharath070.tweetsy.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.sharath070.tweetsy.R
import com.sharath070.tweetsy.navigation.Screens
import com.sharath070.tweetsy.viewModels.CategoryViewModel

@Composable
fun CategoryScreen(navController: NavController) {

    val category = listOf("Android", "System Design", "Motivation", "Facts", "Coding")

    val categoryViewModel: CategoryViewModel = hiltViewModel()
    val categoryList = categoryViewModel.categories.collectAsState()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        items(categoryList.value.distinct()) {
            CategoryItem(it, navController)
        }
    }
}

@Composable
fun CategoryItem(item: String, navController: NavController) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .size(160.dp)
            .clip(RoundedCornerShape(8.dp))
            .paint(
                painter = painterResource(id = R.drawable.wave),
                contentScale = ContentScale.Crop
            )
            .border(1.dp, Color(0xFFEEEEEE))
            .clickable {
                       navController.navigate(route = Screens.TweetsScreen.name + "/$item")
            },
        contentAlignment = Alignment.BottomCenter
    ) {
        Text(
            text = item,
            fontSize = 18.sp,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 20.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}