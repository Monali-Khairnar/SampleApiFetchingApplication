package com.example.sampleapifetchingapplication.data.model.remote

import com.example.sampleapifetchingapplication.data.model.dto.PostsDto
import com.example.sampleapifetchingapplication.domain.model.Posts
import retrofit2.http.GET

interface PostsApi {

    @GET("posts")
    suspend fun getPosts(): List<PostsDto>
}