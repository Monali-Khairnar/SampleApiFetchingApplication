package com.example.sampleapifetchingapplication.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sampleapifetchingapplication.domain.usecase.PostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(private val getPosts: PostsUseCase) : ViewModel() {

    private val _uiState = MutableStateFlow<PostsUIState>(PostsUIState.Loading)
    val uiState: StateFlow<PostsUIState> = _uiState.asStateFlow()

    init {
        loadPosts()
    }

    fun loadPosts() {
        _uiState.value = PostsUIState.Loading

        viewModelScope.launch {
            getPosts()
                .onSuccess { posts ->
                    _uiState.value = PostsUIState.Success(posts = posts)
                }
                .onFailure { exception ->
                    _uiState.value = PostsUIState.Error(
                        exception.message ?: "Something went wrong"
                    )
                }
        }
    }
}