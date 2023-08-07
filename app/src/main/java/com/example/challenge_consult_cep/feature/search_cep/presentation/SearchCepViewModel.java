package com.example.challenge_consult_cep.feature.search_cep.presentation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.challenge_consult_cep.feature.search_cep.domain.use_case.SearchCepUseCase;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SearchCepViewModel extends ViewModel {

    private final SearchCepUseCase useCase;
    private final MutableLiveData<SearchCepUiState> _uiState = new MutableLiveData<>();
    public LiveData<SearchCepUiState> uiState = _uiState;

    public SearchCepViewModel(SearchCepUseCase useCase) {
        this.useCase = useCase;
    }

    public void getCep(String cep) {
        useCase.invoke(cep)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(s -> _uiState.postValue(new SearchCepUiState(true)))
                .subscribe(response -> {
                    _uiState.postValue(new SearchCepUiState(false, "", response));
                }, throwable -> {
                    _uiState.postValue(new SearchCepUiState(false, "Não foi possivel completar a operação, tente mais tarde."));
                });
    }
}

