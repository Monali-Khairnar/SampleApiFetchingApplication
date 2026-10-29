package com.example.sampleapifetchingapplication

import com.example.sampleapifetchingapplication.domain.model.Posts
import com.example.sampleapifetchingapplication.domain.usecase.PostsUseCase
import com.example.sampleapifetchingapplication.presentation.PostsUIState
import com.example.sampleapifetchingapplication.presentation.PostsViewModel
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class ProductViewModelTest {
    private val useCase = mockk<PostsUseCase>()
    private lateinit var viewModel: PostsViewModel

    @Before
    fun setUp() {
        coEvery { useCase() } returns Result.success(emptyList())
        viewModel = PostsViewModel(useCase)
    }

    @Test
    fun `loadPosts emits loading state`() = runTest {
        coEvery { useCase() } coAnswers {
            awaitCancellation()
        }

        viewModel.loadPosts()
        runCurrent()

        assertEquals(PostsUIState.Loading,
            viewModel.uiState.value)
    }

    @Test
    fun `loadProducts returns success`() = runTest {
        val posts = listOf(
            Posts(
                1,
                "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                "quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto"
            )
        )

        coEvery { useCase() } returns Result.success(posts)

        viewModel.loadPosts()

        advanceUntilIdle()

        assertEquals(
            PostsUIState.Success(posts),
            viewModel.uiState.value
        )
    }
}