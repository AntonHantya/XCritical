package com.example.xcritical

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivityRegistration : AppCompatActivity() {

    private val incEmail by lazy {findViewById<TextView>(R.id.textView2) }
    private val inputEmail by lazy { findViewById<EditText>(R.id.inpEmail) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_registration)

        inputEmail.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {

                incEmail.visibility = View.INVISIBLE
            }
        })
    }

    fun isValidString(editText: EditText): Boolean{
        return Patterns.EMAIL_ADDRESS.matcher(editText.text.toString()).matches()
    }

    fun errorData(view: View){
        if (inputEmail.text.isEmpty() || !isValidString(inputEmail)){
            incEmail.visibility = View.VISIBLE
        }
        else{
            incEmail.visibility = View.INVISIBLE
        }
    }
}