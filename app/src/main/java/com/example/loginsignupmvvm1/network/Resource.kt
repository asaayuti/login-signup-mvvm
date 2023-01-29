package com.example.loginsignupmvvm1.network

import okhttp3.ResponseBody

// to handle api success and failure responses
sealed class Resource<out T> {
    // data class to wrap success and failure response inside our resource class
    data class Success<out T>(val value: T) : Resource<T>()
    data class Failure(
        val isNetworkError: Boolean, // value is true when network error
        val errorCode: Int?, // to get actual api error code in case we don't have network error
        val errorResponse: ResponseBody?
    ): Resource<Nothing>()
}