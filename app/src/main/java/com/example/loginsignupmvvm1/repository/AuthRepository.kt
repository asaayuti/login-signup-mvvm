package com.example.loginsignupmvvm1.repository

import com.example.loginsignupmvvm1.network.AuthApi

class AuthRepository(
    private val api: AuthApi
): BaseRepository(){
    // hit login api
    suspend fun login(
        email: String,
        password: String
    ) = safeApiCall {
        api.login(email, password)
    }
}