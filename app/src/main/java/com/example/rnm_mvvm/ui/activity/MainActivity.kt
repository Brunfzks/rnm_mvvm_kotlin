package com.example.rnm_mvvm.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.rnm_mvvm.R
import com.example.rnm_mvvm.adapter.RnmRetunAdapter
import com.example.rnm_mvvm.databinding.ActivityMainBinding
import com.example.rnm_mvvm.model.Character
import com.example.rnm_mvvm.ui.fragment.ItemFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        if(savedInstanceState == null){
//           supportFragmentManager
//               .beginTransaction()
//               .addToBackStack("main_fragment")
//              .add(R.id., ItemFragment())
//                .commit()
//        }


        setUpBottomNavigation()

    }

    private fun setUpBottomNavigation(){
        val navView: BottomNavigationView = binding.bnMenu
        val navController = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        navView.setupWithNavController(navController.navController)

    }

}