package com.example.loginsignupmvvm1.repository

import com.example.loginsignupmvvm1.network.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

// repository is to communicate either local storage and backend api
abstract class BaseRepository {

    suspend fun  <T> safeApiCall(
        apiCall: suspend() -> T
    ) : Resource<T>{
        // execute apiCall
        // withContext(Dispatchers.IO) because to execute all the api call in io dispatcher
        return withContext(Dispatchers.IO){
            // try executing my api call
            try {
                // if apicall successful we will get the result directly
                // and put the result to resource sealed class
                Resource.Success(apiCall.invoke())
            // inside catch block to handle exception/ failure
            }catch (throwable: Throwable){
                when(throwable){
                    is HttpException -> {
                        Resource.Failure(false,throwable.code(), throwable.response()?.errorBody())
                    }
                    else -> {
                        // any other exception
                        Resource.Failure(true, null, null)
                    }
                }
            }
        }

    }
}