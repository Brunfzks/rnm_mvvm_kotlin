package com.example.rnm_mvvm.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.rnm_mvvm.databinding.DetailsCharacterBinding
import com.example.rnm_mvvm.model.Character

class DetailsCharacterFragment : Fragment(){
    private lateinit var binding: DetailsCharacterBinding
    private lateinit var character: Character
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    } // onCreate

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        character = arguments?.getSerializable("desc") as Character

        binding = DetailsCharacterBinding.inflate(inflater, container, false)
        return binding.root
    } // onCreateView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(view).load(character.image).into(binding.image)
        binding.textName.text = character.name
    }

    companion object {
        fun newInstance() = DetailsCharacterFragment()
    }
}