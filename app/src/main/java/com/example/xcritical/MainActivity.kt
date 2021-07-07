package com.example.xcritical

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun incorrectData(view: View){
        val incEmail = findViewById<TextView>(R.id.incorrect_email)
        val incPassword = findViewById<TextView>(R.id.incorrect_password)

        val inputPassword = findViewById<EditText>(R.id.input_password)
        val inputEmail = findViewById<EditText>(R.id.input_email)

        if (inputEmail.text.toString() == ""){
            incEmail.text = "Неверный e-mail"
        }
        else{
            incEmail.text = ""
        }

        if (inputPassword.text.toString() == ""){
            incPassword.text = "Неверный пароль"
        }
        else{
            incPassword.text = ""
        }
    }
}