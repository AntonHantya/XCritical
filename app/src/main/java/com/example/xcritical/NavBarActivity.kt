package com.example.xcritical

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.testFragment -> {
                Toast.makeText(this,"hello",Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }
}