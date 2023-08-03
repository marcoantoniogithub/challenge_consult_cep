package com.example.challenge_consult_cep.feature.search_cep.data

import com.example.challenge_consult_cep.core.BaseTest
import com.example.challenge_consult_cep.feature.search_cep.data.local.SearchCepDataSourceLocal
import com.example.challenge_consult_cep.feature.search_cep.data.remote.SearchCepDataSourceRemote
import com.example.challenge_consult_cep.feature.search_cep.domain.repository.SearchCepRepository
import com.example.challenge_consult_cep.feature.search_cep.mock.CepMock.mockedCep
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Test

class SearchCepRepositoryTest: BaseTest() {

    private val local: SearchCepDataSourceLocal = mockk()
    private val remote: SearchCepDataSourceRemote = mockk()

    private lateinit var repository: SearchCepRepository

    override fun setup() {
        super.setup()
        repository = SearchCepRepositoryImpl(local = local, remote = remote)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `should call getCep when have cep in local return local`() =
        kotlinx.coroutines.test.runTest {
            val exampleCep = "04538133"
            val mockResultLocal = mockedCep()

            coEvery { local.getById(exampleCep) } returns mockResultLocal

            val result = repository.getCep(exampleCep)

            coVerify(exactly = 0) { remote.getCep(exampleCep) }

            assertEquals(mockResultLocal, result)
        }

    @ExperimentalCoroutinesApi
    @Test
    fun `should call getCep when don't have cep in local return remote`() =
        kotlinx.coroutines.test.runTest {
            val exampleCep = "04538133"
            val mockResultLocal = Exception("")
            val mockResultRemote = mockedCep()

            coEvery { local.getById(exampleCep) } throws mockResultLocal
            coEvery { remote.getCep(exampleCep) } returns mockResultRemote
            coEvery { local.insertItem(mockResultRemote) } returns Unit

            val result = repository.getCep(exampleCep)

            coVerify(exactly = 1) { local.getById(exampleCep) }
            coVerify(exactly = 1) { remote.getCep(exampleCep) }
            coVerify(exactly = 1) { local.insertItem(mockResultRemote) }

            assertEquals(mockResultRemote, result)
        }

    @ExperimentalCoroutinesApi
    @Test(expected = Exception::class)
    fun `should call getCep when don't have cep in local and remote return error`() =
        kotlinx.coroutines.test.runTest {
            val exampleCep = "04538133"
            val mockResultException = Exception()

            coEvery { local.getById(exampleCep) } throws mockResultException
            coEvery { remote.getCep(exampleCep) } throws mockResultException

            repository.getCep(exampleCep)
        }
}