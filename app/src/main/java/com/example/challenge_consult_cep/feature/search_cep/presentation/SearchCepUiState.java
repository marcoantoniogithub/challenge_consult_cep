package com.example.challenge_consult_cep.feature.search_cep.presentation;

import com.example.challenge_consult_cep.feature.search_cep.domain.model.Cep;

public class SearchCepUiState {

    public boolean loading;
    public String messageError;
    public Cep cep;

    public SearchCepUiState(boolean loading, String messageError, Cep cep) {
        this.loading = loading;
        this.messageError = messageError;
        this.cep = cep;
    }

    public SearchCepUiState(boolean loading, String messageError) {
        this.loading = loading;
        this.messageError = messageError;
    }

    public SearchCepUiState(boolean loading) {
        this.loading = loading;
    }
}
