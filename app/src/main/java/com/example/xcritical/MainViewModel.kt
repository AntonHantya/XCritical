package com.example.xcritical

import android.util.Patterns
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var email = ""
    var password = ""

    fun incorrectEmail() : Boolean {
        return ( !Patterns.EMAIL_ADDRESS.matcher(email).matches())
    }

    fun incorrectPassword() : Boolean {
        return password.isEmpty()
    }
}