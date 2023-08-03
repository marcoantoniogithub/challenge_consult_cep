package com.example.challenge_consult_cep.feature.search_cep.domain.use_case

import com.example.challenge_consult_cep.core.BaseTest
import com.example.challenge_consult_cep.feature.search_cep.domain.repository.SearchCepRepository
import com.example.challenge_consult_cep.feature.search_cep.mock.CepMock.mockedCep
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Test

class SearchCepUseCaseTest : BaseTest() {

    private val searchCepRepository: SearchCepRepository = mockk()
    private lateinit var useCase: SearchCepUseCase

    override fun setup() {
        super.setup()
        useCase = SearchCepUseCase(searchCepRepository)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `should call repository when get cep is called`() =
        kotlinx.coroutines.test.runTest {
            val exampleCep = "04538133"
            val mockResult = mockedCep()

            coEvery { searchCepRepository.getCep(exampleCep) } returns mockResult

            val result = useCase.invoke(exampleCep)

            assertEquals(mockResult, result)
        }
}