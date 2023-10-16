package com.example.rnm_mvvm.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.rnm_mvvm.adapter.RnmRetunAdapter
import com.example.rnm_mvvm.databinding.FragmentListCharacterBinding
import com.example.rnm_mvvm.model.Character
import com.example.rnm_mvvm.model.RnmReturn
import com.example.rnm_mvvm.networkService.ApiState
import com.example.rnm_mvvm.repositories.CharacterRepository
import com.example.rnm_mvvm.viewModel.CharacterViewModel
import com.example.rnm_mvvm.viewModel.CharacterViewModelFactory
import kotlinx.coroutines.launch


class ItemFragment : Fragment() {

    private lateinit var characterVM: CharacterViewModel

    private lateinit var binding: FragmentListCharacterBinding

    private lateinit var characterAdapter: RnmRetunAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        characterVM = ViewModelProvider(
            this,
            CharacterViewModelFactory(CharacterRepository())
        )[CharacterViewModel::class.java]

    } // onCreate

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListCharacterBinding.inflate(inflater, container, false)
        return binding.root
    } // onCreateView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        initUI()

        collects() // Like observers of live data

        listeners()

    } // onViewCreated

    private fun initUI() {
        characterAdapter = RnmRetunAdapter(characterVM.items)

        binding.rvCharacters.adapter = characterAdapter
        binding.srlCharacters.setOnRefreshListener {
            characterVM.getCharacter()
        }
        if (characterVM.items.results.isEmpty()) {
            binding.srlCharacters.post {
                characterVM.getCharacter()
            }
        }


    } // initUI

    private fun collects() {

        lifecycleScope.launch {
            characterVM.wMessage.collect {
                when (it) {
                    is ApiState.Loading -> {
                        binding.srlCharacters.isRefreshing = true
                    }

                    is ApiState.Failure -> {
                        it.e.printStackTrace()
                        binding.srlCharacters.isRefreshing = false
                    }

                    is ApiState.Success -> {

                        binding.srlCharacters.isRefreshing = false
                        val myObj = it.data as RnmReturn
                        characterVM.items.results.clear()
                        characterVM.items.results.addAll(myObj.results)
                        characterAdapter.notifyDataSetChanged()

                    }

                    is ApiState.Empty -> {
                        println("Empty...")
                    }
                }
            }
        }

    } // collects

    private fun listeners() {
        characterAdapter.setItemClick {
            Toast.makeText(activity, "Clicked ${it.name}", Toast.LENGTH_SHORT).show()
        }
    }

}