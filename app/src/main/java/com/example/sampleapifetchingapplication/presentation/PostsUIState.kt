package com.example.sampleapifetchingapplication.presentation

import com.example.sampleapifetchingapplication.domain.model.Posts

sealed interface PostsUIState {

    object Loading : PostsUIState

    data class Success(val posts: List<Posts>) : PostsUIState

    data class Error(val message: String) : PostsUIState
}