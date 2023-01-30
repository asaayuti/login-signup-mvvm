package com.example.loginsignupmvvm1.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.loginsignupmvvm1.repository.AuthRepository
import com.example.loginsignupmvvm1.repository.BaseRepository
import com.example.loginsignupmvvm1.ui.auth.AuthViewModel

class ViewModelFactory(
    private val repository: BaseRepository
): ViewModelProvider.NewInstanceFactory() {

    // create view model
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when{
            // view model instance
            modelClass.isAssignableFrom(AuthViewModel::class.java) -> AuthViewModel(repository as AuthRepository) as T

            else -> throw IllegalArgumentException("ViewModelClass not found")
        }
    }
}