package com.example.xcritical

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.xcritical.databinding.ActivityNavBarBinding
import com.example.xcritical.databinding.FragmentFolderBinding


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

        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = ""

        val signOutButton = Intent(this, MainActivity::class.java)


        binding.apply {
            navDrawer.setNavigationItemSelectedListener {

                when (it.itemId) {
                    R.id.info -> {
                        navigationController.navigate(R.id.infoFragment)
                    }
                    R.id.help -> {
                        navigationController.navigate(R.id.helpFragment)
                    }
                    R.id.bell -> {
                        navigationController.navigate(R.id.bellFragment)
                    }
                    R.id.subscribe -> {
                        navigationController.navigate(R.id.subscribeFragment)
                    }
                    R.id.settings -> {
                        navigationController.navigate(R.id.settingsFragment)
                    }
                    R.id.signout -> {
                        startActivity(signOutButton)
                    }
                }
                drawer.closeDrawer((GravityCompat.START))
                true
            }
        }

        val listButton: ImageButton = this.findViewById(R.id.btn_list_menu) as ImageButton
        listButton.setOnClickListener {
            binding.drawer.openDrawer(GravityCompat.START)
        }
        setCloseDrawerListener()

        navigationController.addOnDestinationChangedListener{ _, destination, _ ->
            when(destination.id){
                R.id.folderFragment -> {
                    binding.toolbar.visibility = View.VISIBLE
                    binding.bottomNavigationView.visibility = View.VISIBLE
                }
                R.id.plusFragment -> {
                    binding.toolbar.visibility = View.GONE
                    binding.bottomNavigationView.visibility = View.GONE


                }
                R.id.imageFragment -> {
                    binding.toolbar.visibility = View.VISIBLE
                    binding.bottomNavigationView.visibility = View.VISIBLE
                }
            }
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



    private fun setCloseDrawerListener(){
        val headerView = binding.navDrawer?.getHeaderView(0)
        val closeDrawer = headerView?.findViewById<ImageButton>(R.id.closeButton)
        if (closeDrawer != null) {
            closeDrawer.setOnClickListener {
                binding.drawer.closeDrawer(GravityCompat.START)
            }
        }
    }
}