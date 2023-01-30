package com.example.loginsignupmvvm1.ui.auth

import androidx.lifecycle.ViewModel
import com.example.loginsignupmvvm1.repository.AuthRepository

// view model will communicate to repository and hit backend api
class AuthViewModel(
    private val repository: AuthRepository
): ViewModel() {

}