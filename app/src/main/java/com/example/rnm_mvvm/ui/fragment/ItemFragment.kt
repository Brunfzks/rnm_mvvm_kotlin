package com.example.rnm_mvvm.ui.fragment

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.rnm_mvvm.App
import com.example.rnm_mvvm.R
import com.example.rnm_mvvm.adapter.RnmRetunAdapter
import com.example.rnm_mvvm.databinding.FragmentListCharacterBinding
import com.example.rnm_mvvm.model.RnmReturn
import com.example.rnm_mvvm.networkService.ApiState
import com.example.rnm_mvvm.repositories.CharacterRepository
import com.example.rnm_mvvm.viewModel.CharacterViewModel
import com.example.rnm_mvvm.viewModel.CharacterViewModelFactory
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import javax.inject.Inject


class ItemFragment : Fragment() {

    private lateinit var characterVM: CharacterViewModel

    private lateinit var binding: FragmentListCharacterBinding

    private lateinit var characterAdapter: RnmRetunAdapter

    private val mCompositeDisposable = CompositeDisposable()

    @Inject
    lateinit var characterRepository: CharacterRepository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (activity?.application as App).getCharacterRepositoryComponent().inject(this)

        characterVM = ViewModelProvider(
            this,
            CharacterViewModelFactory(characterRepository)
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

        listeners()

    } // onViewCreated

    private fun initUI() {
        characterAdapter = RnmRetunAdapter(characterVM.items)

        binding.rvCharacters.adapter = characterAdapter
        binding.srlCharacters.setOnRefreshListener {
            collects()
        }
        if (characterVM.items.results.isEmpty()) {
            binding.srlCharacters.post {
                collects()
            }
        }


    } // initUI

    private fun collects() {

        mCompositeDisposable.clear()
        binding.srlCharacters.isRefreshing = true

        mCompositeDisposable.add(
            characterVM.getCharacter()
                .subscribe({
                    binding.srlCharacters.isRefreshing = false
                    characterVM.items.results.clear()
                    characterVM.items.results.addAll(it.results)
                    characterAdapter.notifyDataSetChanged()
                }, {
                    binding.srlCharacters.isRefreshing = false
                })
        )

    } // collects

    private fun listeners() {
        characterAdapter.setItemClick {

            var bundle = Bundle()
            bundle.putSerializable("desc", it)
            val fragment = DetailsCharacterFragment()
            fragment.arguments = bundle


            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.nav_host_fragment_container, fragment, "fragmentDetail")
                ?.addToBackStack(null)
                ?.commit();
        }
    }

}