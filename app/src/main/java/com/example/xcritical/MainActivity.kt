package com.example.xcritical

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private val incEmail by lazy {findViewById<TextView>(R.id.incorrect_email) }
    private val incPassword by lazy { findViewById<TextView>(R.id.incorrect_password) }
    private val inputPassword by lazy { findViewById<EditText>(R.id.input_password) }
    private val inputEmail by lazy { findViewById<EditText>(R.id.input_email) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputEmail.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {

                    incEmail.visibility = View.INVISIBLE

            }

        })
    }


    private fun isValidString(editText: EditText): Boolean{
        return Patterns.EMAIL_ADDRESS.matcher(editText.text.toString()).matches()
    }

    fun incorrectData(view: View){
        if (inputEmail.text.isEmpty() || !isValidString(inputEmail)){
            incEmail.visibility = View.VISIBLE
        }
        else{
            incEmail.visibility = View.INVISIBLE
        }

        if (inputPassword.text.toString() == ""){
            incPassword.visibility = View.VISIBLE
        }
        else{
            incPassword.visibility = View.INVISIBLE
        }
    }

    fun reg(view: View) {
        val registr = Intent(this, MainActivityRegistration::class.java)
        startActivity(registr)
    }
}