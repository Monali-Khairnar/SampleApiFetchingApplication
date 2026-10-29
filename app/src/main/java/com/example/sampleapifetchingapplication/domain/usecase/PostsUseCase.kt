package com.example.sampleapifetchingapplication.domain.usecase

import com.example.sampleapifetchingapplication.domain.PostsRepository
import com.example.sampleapifetchingapplication.domain.model.Posts
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PostsUseCase @Inject constructor(private val repository: PostsRepository) {

    suspend operator fun invoke(): Result<List<Posts>> = repository.getPosts()
}