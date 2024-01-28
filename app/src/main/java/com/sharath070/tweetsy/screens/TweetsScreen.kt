package com.sharath070.tweetsy.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sharath070.tweetsy.viewModels.TweetsViewModel

@Preview
@Composable
fun TweetScreen() {

    val tweetsViewModel: TweetsViewModel = hiltViewModel()
    val tweets = tweetsViewModel.tweets.collectAsState()

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(tweets.value) {
            CardItem(it.text)
        }
    }
}

@Composable
fun CardItem(text: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        border = BorderStroke(width = 1.dp, color = Color(0xffcccccc))
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black
        )
    }
}