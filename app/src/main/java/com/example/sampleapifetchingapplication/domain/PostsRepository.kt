package com.example.sampleapifetchingapplication.domain

import com.example.sampleapifetchingapplication.domain.model.Posts
import kotlinx.coroutines.flow.Flow

interface PostsRepository {

   suspend fun getPosts(): Result<List<Posts>>
}