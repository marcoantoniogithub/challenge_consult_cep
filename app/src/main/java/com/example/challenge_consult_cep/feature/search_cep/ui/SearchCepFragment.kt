package com.example.challenge_consult_cep.feature.search_cep.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.challenge_consult_cep.databinding.FragmentSearchCepBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchCepFragment : Fragment() {

    private var _binding: FragmentSearchCepBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SearchCepViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchCepBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observers()
    }

    private fun observers() {
        binding.inputCep.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                validateCep(s.toString())
            }
        })

        viewModel.uiState.observe(viewLifecycleOwner) { it ->
            if (it.loading) {
                binding.userListProgressBar.visibility = View.VISIBLE
            } else {
                binding.userListProgressBar.visibility = View.GONE
            }

            if (it.messageError != "") {
                binding.userListProgressBar.visibility = View.GONE
                binding.result.visibility = View.GONE

                Toast.makeText(context, it.messageError, Toast.LENGTH_SHORT)
                    .show()
            }

            it.cep?.let { cep ->
                binding.userListProgressBar.visibility = View.GONE
                binding.result.visibility = View.VISIBLE

                clearInput()

                binding.txtCep.text = cep.code
                binding.txtState.text = cep.state
                binding.txtCity.text = cep.city
                binding.txtNeighborhood.text = cep.neighborhood
                binding.txtAddress.text = cep.address
            }
        }
    }

    fun validateCep(cep: String) {
        if (cep.length == 8) {
            viewModel.getCep(cep)
        }
    }

    fun clearInput() {
        binding.inputCep.text!!.clear()
    }
}