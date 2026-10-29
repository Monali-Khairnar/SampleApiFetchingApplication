package com.example.sampleapifetchingapplication.di

import com.example.sampleapifetchingapplication.data.repository.PostsRepositoryImpl
import com.example.sampleapifetchingapplication.domain.PostsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRepository(impl: PostsRepositoryImpl): PostsRepository
}