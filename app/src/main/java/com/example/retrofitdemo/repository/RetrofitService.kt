package com.example.retrofitdemo.repository

import com.example.retrofitdemo.data.models.User
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    @GET("users")
    suspend fun getAllUsers() : Response<List<User>>
}