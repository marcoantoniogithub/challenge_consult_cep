package com.example.challenge_consult_cep.feature.search_cep.presentation;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.challenge_consult_cep.databinding.FragmentSearchCepBinding;
import com.example.challenge_consult_cep.feature.search_cep.di.SearchCepModule;

import org.jetbrains.annotations.NotNull;

public class SearchCepFragment extends Fragment {

    private FragmentSearchCepBinding _binding;
    private FragmentSearchCepBinding getBinding() {
        return _binding;
    }

    private SearchCepViewModel viewModel;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        _binding = FragmentSearchCepBinding.inflate(inflater, container, false);
        return getBinding().getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = SearchCepModule.provideSearchCepViewModel(requireContext());
        observers();
    }

    private void observers() {
        getBinding().inputCep.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validateCep(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        getBinding().button.setOnClickListener(v -> searchInput());

        viewModel.uiState.observe(getViewLifecycleOwner(), it -> {
            if (it.loading) {
                getBinding().userListProgressBar.setVisibility(View.VISIBLE);
            } else {
                getBinding().userListProgressBar.setVisibility(View.GONE);
            }

            if (it.messageError != null && !it.messageError.isEmpty()) {
                getBinding().userListProgressBar.setVisibility(View.GONE);
                getBinding().result.setVisibility(View.GONE);

                Toast.makeText(requireContext(), it.messageError, Toast.LENGTH_SHORT).show();
            }

            if (it.cep != null) {
                getBinding().userListProgressBar.setVisibility(View.GONE);
                getBinding().result.setVisibility(View.VISIBLE);

                clearInput();

                getBinding().txtCep.setText(it.cep.getCode());
                getBinding().txtState.setText(it.cep.getState());
                getBinding().txtCity.setText(it.cep.getCity());
                getBinding().txtNeighborhood.setText(it.cep.getNeighborhood());
                getBinding().txtAddress.setText(it.cep.getAddress());
            }
        });
    }

    public void validateCep(String cep) {
        enabledButton(cep.length() == 8);
    }

    public void searchInput() {
        hideKeyboarding();
        viewModel.getCep(getBinding().inputCep.getText().toString());
    }

    public void hideKeyboarding() {
        InputMethodManager imm = (InputMethodManager) requireContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        View focusedView = requireActivity().getCurrentFocus();
        if (focusedView != null) {
            imm.hideSoftInputFromWindow(focusedView.getWindowToken(), 0);
        }
    }

    public boolean enabledButton(boolean enabled) {
        getBinding().button.setEnabled(enabled);
        return enabled;
    }

    public void clearInput() {
        getBinding().inputCep.getText().clear();
    }
}