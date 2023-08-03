package com.example.challenge_consult_cep.feature.search_cep.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.challenge_consult_cep.feature.search_cep.domain.model.Cep
import com.example.challenge_consult_cep.feature.search_cep.domain.use_case.SearchCepUseCase
import kotlinx.coroutines.launch

class SearchCepViewModel(
    val useCase: SearchCepUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<SearchCepUiState>()
    val uiState: LiveData<SearchCepUiState> = _uiState

    fun getCep(cep: String) {
        viewModelScope.launch {
            try {
                _uiState.postValue(SearchCepUiState(loading = true))
                val response = useCase.invoke(cep)
                _uiState.postValue(SearchCepUiState(loading = false, messageError = "", cep = response))
            } catch (e: Exception) {
                _uiState.postValue(SearchCepUiState(loading = false, messageError = "Não foi possivel completar a operação, tente mais tarde."))
            }
        }
    }
}

data class SearchCepUiState(
    var loading: Boolean = false, var messageError: String = "", var cep: Cep? = null
)