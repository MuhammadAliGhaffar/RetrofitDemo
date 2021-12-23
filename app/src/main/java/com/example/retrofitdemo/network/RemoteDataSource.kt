package com.example.retrofitdemo.network

import com.example.retrofitdemo.data.models.User
import retrofit2.Response
import retrofit2.http.GET

interface RemoteDataSource {

    @GET("users")
    suspend fun getAllUsers(): Response<List<User>>
}
