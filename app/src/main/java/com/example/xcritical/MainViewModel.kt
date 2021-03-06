package com.example.xcritical

import android.app.Application
import android.util.Patterns
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.regex.Pattern

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val EMAIL_ADDRESS_PATTERN = Pattern.compile(
        "(?:[a-z0-9!#\$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#\$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])"
    )
    private val _isInvalidLiveDataEmail = MutableLiveData<Boolean>().apply { value = true }
    val isInvalidLiveDataEmail: LiveData<Boolean>
        get() = _isInvalidLiveDataEmail

    private val _isInvalidLiveDataPassword = MutableLiveData<Boolean>().apply { value = true }
    val isInvalidLiveDataPassword: LiveData<Boolean>
        get() = _isInvalidLiveDataPassword

    private val _isPassedValidation = MutableLiveData<Boolean>().apply { value = true }
    val isPassedValidation: LiveData<Boolean>
        get() = _isPassedValidation

    private val _isChangingEmailText = MutableLiveData<Boolean>().apply { value = true }
    val isChangingEmailText: LiveData<Boolean>
        get() = _isChangingEmailText

    private val _isChangingPasswordText = MutableLiveData<Boolean>().apply { value = true }
    val isChangingPasswordText: LiveData<Boolean>
        get() = _isChangingPasswordText

    fun onEmailTextChanged(s: CharSequence,start: Int,before : Int, count :Int){
        _isChangingEmailText.value = true
    }

    fun onPasswordTextChanged(s: CharSequence,start: Int,before : Int, count :Int){
        _isChangingPasswordText.value = true
    }

    fun validateLogin(email: String?, password: String?){
        val mail = validateEmail(email)
        val pass = validatePassword(password)

        _isPassedValidation.value = !(mail!! || pass!!)
    }


    fun validateEmail(email: String?): Boolean? {
        _isInvalidLiveDataEmail.value = email.isNullOrEmpty() || !EMAIL_ADDRESS_PATTERN.matcher(email).matches()
        return _isInvalidLiveDataEmail.value
    }


    private fun validatePassword(password: String?): Boolean? {
        _isInvalidLiveDataPassword.value = password.isNullOrEmpty()
        return _isInvalidLiveDataPassword.value
    }
}