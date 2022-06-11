package com.tsci.flightapp.presentation.ui.login

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(

): ViewModel() {

    private val mail: String = "buraktasci@gmail.com"
    private val password: String = "12345678"

    fun checkMailAndPassword(mail: String, password: String): Boolean {
        return if (mail.equals(this.mail) && password.equals(this.password))
            true
        else
            false
    }
}