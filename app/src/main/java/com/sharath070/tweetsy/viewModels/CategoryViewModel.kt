package com.sharath070.tweetsy.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sharath070.tweetsy.repository.TweetsyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val repository: TweetsyRepository) :
    ViewModel() {

    val categories: StateFlow<List<String>>
        get() = repository.categories

    init {
        viewModelScope.launch {
            repository.getCategories()
        }
    }

}