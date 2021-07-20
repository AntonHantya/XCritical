package com.example.xcritical

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.xcritical.databinding.ActivityNavBarBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NavBarActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNavBarBinding
    private lateinit var navigationController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavBarBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initializeListeners()

        navigationController = findNavController(R.id.fragment)
        binding.bottomNavigationView.setupWithNavController(navigationController)

    }
    private fun initializeListeners(){
        binding.projectsFab.setOnClickListener{
            navigationController.navigate(R.id.plusFragment)
        }
    }
}