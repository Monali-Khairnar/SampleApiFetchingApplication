package com.example.sampleapifetchingapplication.data.repository

import com.example.sampleapifetchingapplication.data.model.mapper.toDomain
import com.example.sampleapifetchingapplication.data.model.remote.PostsApi
import com.example.sampleapifetchingapplication.domain.PostsRepository
import com.example.sampleapifetchingapplication.domain.model.Posts
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PostsRepositoryImpl @Inject constructor(private val postsApi: PostsApi) : PostsRepository {

    override suspend fun getPosts(): Result<List<Posts>> {
        return try {
            val postsDTOs = postsApi.getPosts()
            Result.success(postsDTOs.map { it.toDomain() })
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}