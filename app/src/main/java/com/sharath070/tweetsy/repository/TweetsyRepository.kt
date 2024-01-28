package com.sharath070.tweetsy.repository

import com.sharath070.tweetsy.api.TweetsyApi
import com.sharath070.tweetsy.models.TweetListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class TweetsyRepository @Inject constructor(private val api: TweetsyApi) {

    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories = _categories.asStateFlow()

    private val _tweets = MutableStateFlow<Array<TweetListItem>>(emptyArray())
    val tweets = _tweets.asStateFlow()

    suspend fun getCategories() {
        val response = api.getCategories()
        if (response.isSuccessful && response.body() != null) {
            _categories.emit(response.body()!!)
        }
    }

    suspend fun getTweets(category: String) {
        val response = api.getTweets("tweets[?(@.category==\"$category\")]")
        if (response.isSuccessful && response.body() != null) {
            _tweets.emit(response.body()!!)
        }
    }
}