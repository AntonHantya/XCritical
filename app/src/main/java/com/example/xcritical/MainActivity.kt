package com.example.xcritical

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {

    private val incEmail by lazy {findViewById<TextView>(R.id.incorrect_email) }
    private val incPassword by lazy { findViewById<TextView>(R.id.incorrect_password) }
    private val inputPassword by lazy { findViewById<EditText>(R.id.input_password) }
    private val inputEmail by lazy { findViewById<EditText>(R.id.input_email) }
    private val buttonLogin by lazy { findViewById<Button>(R.id.button_sign_in) }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        initListener()

        buttonLogin.setOnClickListener() {
            viewModel.email = inputEmail.text.toString()
            viewModel.password = inputPassword.text.toString()
            var eml: Boolean = false
            var pas: Boolean = false

            if(viewModel.incorrectEmail()) {
                incEmail.visibility = View.VISIBLE
                eml = false
            }
            else {
                incEmail.visibility = View.INVISIBLE
                eml = true
            }
            if(viewModel.incorrectPassword())
            {
                incPassword.visibility = View.VISIBLE
                pas = false
            }
            else {
                incPassword.visibility = View.INVISIBLE
                pas = true
            }
            if(eml && pas){
                val login = Intent(this, BottomNavBar::class.java)
                startActivity(login)
            }
        }
    }

    private fun initListener() {
        inputEmail.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                incEmail.visibility = View.INVISIBLE

            }
        })

        inputPassword.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                incPassword.visibility = View.INVISIBLE

            }
        })
    }

    fun reg(view: View) {
        val registr = Intent(this, MainActivityRegistration::class.java)
        startActivity(registr)
    }
}