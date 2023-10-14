package com.example.rnm_mvvm.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rnm_mvvm.R
import com.example.rnm_mvvm.databinding.ActivityMainBinding
import com.example.rnm_mvvm.ui.fragment.ItemFragment


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .addToBackStack("ItemFragment")
            .add(R.id.frameLayout, ItemFragment())
            .commit()

    }

}