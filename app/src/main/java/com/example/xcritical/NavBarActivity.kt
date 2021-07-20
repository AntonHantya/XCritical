package com.example.xcritical

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.xcritical.databinding.ActivityNavBarBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_nav_bar.*

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
        setSupportActionBar(toolbar)
        supportActionBar?.title = ""

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
            R.id.gridfour_item -> {
                Toast.makeText(this,"Grid item",Toast.LENGTH_SHORT).show()
            }
            R.id.chat_item -> {
                Toast.makeText(this,"Chat item",Toast.LENGTH_SHORT).show()
            }
            R.id.refresh_item -> {
                val intent = Intent(this, MainActivityRegistration::class.java)
                startActivity(intent)            }
            R.id.list_item -> {
                Toast.makeText(this,"List item",Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }
}