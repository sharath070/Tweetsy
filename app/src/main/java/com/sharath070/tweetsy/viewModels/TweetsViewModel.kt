package com.sharath070.tweetsy.viewModels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sharath070.tweetsy.models.TweetListItem
import com.sharath070.tweetsy.repository.TweetsyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TweetsViewModel @Inject constructor(
    private val repository: TweetsyRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val tweets: StateFlow<Array<TweetListItem>>
        get() = repository.tweets

    init {
        val category = savedStateHandle.get<String>("category") ?: "Motivation"
        viewModelScope.launch {
            repository.getTweets(capitalizeFirstLetters(category))
        }
    }

    private fun capitalizeFirstLetters(text: String): String {
        return text.split(" ").joinToString(" ") { it.first().uppercase() + it.substring(1) }
    }
}