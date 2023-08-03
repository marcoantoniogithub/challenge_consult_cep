package com.example.challenge_consult_cep.feature.search_cep.presentation

import com.example.challenge_consult_cep.core.BaseTest
import com.example.challenge_consult_cep.feature.search_cep.domain.use_case.SearchCepUseCase
import com.example.challenge_consult_cep.feature.search_cep.mock.CepMock.mockedCep
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Test

class SearchCepViewModelTest : BaseTest() {

    private val useCase: SearchCepUseCase = mockk()
    private lateinit var viewModel: SearchCepViewModel

    override fun setup() {
        super.setup()
        viewModel = SearchCepViewModel(useCase)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `should call use case when get cep is called`() = kotlinx.coroutines.test.runTest {
        val mockResult = mockedCep()
        val exampleCep = "04538133"

        coEvery { useCase.invoke(exampleCep) } returns mockResult

        viewModel.getCep(exampleCep)

        coVerify(exactly = 1) { useCase.invoke(exampleCep) }

        assertEquals(mockResult, viewModel.uiState.value?.cep)
        assertEquals("", viewModel.uiState.value?.messageError)
    }


    @ExperimentalCoroutinesApi
    @Test
    fun `should throw an exception when get cep is called`() = kotlinx.coroutines.test.runTest {
        val msgError = "falhou no teste"
        val msgGenericError = "Não foi possivel completar a operação, tente mais tarde."
        val exampleCep = "04538133"
        coEvery { useCase.invoke(exampleCep) } throws Exception(msgError)

        viewModel.getCep(exampleCep)

        coVerify { useCase.invoke(exampleCep) }
        assertEquals(viewModel.uiState.value?.messageError, msgGenericError)
        assertEquals(viewModel.uiState.value?.cep, null)
    }
}