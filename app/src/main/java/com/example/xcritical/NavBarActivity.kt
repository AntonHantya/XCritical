package com.example.xcritical

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import android.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.xcritical.databinding.ActivityMainBinding.inflate
import com.example.xcritical.databinding.ActivityNavBarBinding
import com.example.xcritical.databinding.FragmentFolderBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_nav_bar.*
import kotlinx.android.synthetic.main.fragment_folder.*

class NavBarActivity : AppCompatActivity() {


    private lateinit var binding : ActivityNavBarBinding
    private lateinit var navigationController: NavController
    private lateinit var folder : FragmentFolderBinding
    var flag: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavBarBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initializeListeners()

        folder = FragmentFolderBinding.bind(view)

        navigationController = findNavController(R.id.fragment)
        binding.bottomNavigationView.setupWithNavController(navigationController)

        setSupportActionBar(toolbar)
        supportActionBar?.title = ""

        binding.apply {
            navDrawer.setNavigationItemSelectedListener {
                when(it.itemId){
                    R.id.info -> {
                        Toast.makeText(this@NavBarActivity,"О приложении",Toast.LENGTH_SHORT).show()
                    }
                    R.id.help -> {
                        Toast.makeText(this@NavBarActivity,"Связаться с поддержкой",Toast.LENGTH_SHORT).show()
                    }
                    R.id.bell -> {
                        Toast.makeText(this@NavBarActivity,"Уведомления",Toast.LENGTH_SHORT).show()
                    }
                    R.id.subscribe -> {
                        Toast.makeText(this@NavBarActivity,"Pro подписка",Toast.LENGTH_SHORT).show()
                    }
                    R.id.settings -> {
                        Toast.makeText(this@NavBarActivity,"Настройки",Toast.LENGTH_SHORT).show()
                    }
                    R.id.signout -> {
                        Toast.makeText(this@NavBarActivity,"Выйти",Toast.LENGTH_SHORT).show()
                    }
                }
                true
            }
        }

        val listButton: ImageButton = this.findViewById(R.id.btn_list_menu) as ImageButton
        listButton.setOnClickListener {
            Toast.makeText(this, "TESTING BUTTON CLICK 1", Toast.LENGTH_SHORT).show()
        }



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
                if (flag){
                    folder.recyclerView.apply {
                        layoutManager = GridLayoutManager(this@NavBarActivity,2,GridLayoutManager.VERTICAL,false)
                    }
                    flag = false
                }
                else{
                    folder.recyclerView.apply {
                        layoutManager = LinearLayoutManager(this@NavBarActivity)
                    }
                    flag = true
                }
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