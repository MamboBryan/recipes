package com.bizyback.play.recipe.domain.repositories

import com.bizyback.play.recipe.data.domain.models.DataResult
import com.bizyback.play.recipe.data.domain.models.Recipe
import com.bizyback.play.recipe.data.domain.models.RecipeType
import com.bizyback.play.recipe.data.domain.repositories.RecipeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test

/**
 * @project : Recipe
 * @author  : mambo
 * @email   : mambobryan@gmail.com
 * @date    : Sun 31 December 2023
 * @time    : 1:56 pm
 */

private class FakeRecipeRepository : RecipeRepository {

    private val state: MutableStateFlow<List<Recipe>?> = MutableStateFlow(null)

    fun setResponseToBeError() {
        updateList(null)
    }

    fun setResponseToBeSuccessButEmpty() {
        updateList(emptyList())
    }

    fun setResponseToBeSuccessWithData() {
        updateList(listOf(Recipe("Banana Bread", "")))
    }

    private fun updateList(list: List<Recipe>?) {
        state.value = list
    }

    fun clearData() {
        state.value = null
    }

    override suspend fun searchRecipes(type: RecipeType, query: String): DataResult<List<Recipe>> {
        return if (state.value == null) {
            DataResult.Error(message = "Failed getting recipes")
        } else {
            DataResult.Success(data = state.value ?: emptyList())
        }
    }

}

class RecipeRepositoryTest {

    private lateinit var repository: FakeRecipeRepository

    @Before
    fun setup() {
        repository = FakeRecipeRepository()
    }

    @After
    fun tearDown() {
        repository.clearData()
    }

    @Test
    fun `given RecipeRepository, when searching recipes, should return error`() = runTest {
        repository.setResponseToBeError()
        val result = repository.searchRecipes(query = "banana")
        assert(result is DataResult.Error)
    }

    @Test
    fun `given RecipeRepository, when searching recipes, should return success with empty`() =
        runTest {
            repository.setResponseToBeSuccessButEmpty()
            val result = repository.searchRecipes(query = "banana")
            assert(result is DataResult.Success)
            val data = (result as DataResult.Success).data
            assert(data.isEmpty())
        }

    @Test
    fun `given RecipeRepository, when searching recipes, should return success with data`() =
        runTest {
            repository.setResponseToBeSuccessWithData()
            val result = repository.searchRecipes(query = "banana")
            assert(result is DataResult.Success)
            val data = (result as DataResult.Success).data
            assert(data.first().label == "Banana Bread")
        }

}