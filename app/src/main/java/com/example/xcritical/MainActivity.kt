package com.example.xcritical

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputBinding
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.xcritical.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.mainViewModel = viewModel

        viewModel.isInvalidLiveDataEmail.observe(this, {
            if (it) {
                binding.incorrectEmail.visibility = View.VISIBLE
            }
        })

        viewModel.isInvalidLiveDataPassword.observe(this, {
            if (it) {
                binding.incorrectPassword.visibility = View.VISIBLE
            }
        })

        viewModel.isPassedValidation.observe(this, {
            if (it) {
                val intentMainTeleprompterActivity = Intent(this, NavBarActivity::class.java)
                startActivity(intentMainTeleprompterActivity)
            }
        })

        viewModel.isChangingEmailText.observe(this, {
            if (it) {
                binding.incorrectEmail.visibility = View.INVISIBLE
            }
        })

        viewModel.isChangingPasswordText.observe(this, {
            if (it) {
                binding.incorrectPassword.visibility = View.INVISIBLE
            }
        })

        binding.forgotPas.setOnClickListener {
            val intent = Intent(this, MainActivityRegistration::class.java)
            startActivity(intent)
        }
        binding.buttonRegistration.setOnClickListener{
            val intent = Intent(this, MainActivityRegistration::class.java)
            startActivity(intent)
        }
    }
}