package com.example.sampleapifetchingapplication.data.model.mapper

import com.example.sampleapifetchingapplication.data.model.dto.PostsDto
import com.example.sampleapifetchingapplication.domain.model.Posts

fun PostsDto.toDomain(): Posts{
    return Posts(
        id = id,
        title = title,
        body = body
    )
}