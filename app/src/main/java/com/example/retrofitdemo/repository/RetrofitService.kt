package com.example.retrofitdemo.repository

import com.example.retrofitdemo.data.models.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    @GET("users")
    fun getAllUsers() : Call<List<User>>

    companion object {

        var retrofitService: RetrofitService? = null
        var BaseUrl = "https://api.github.com/"

        fun getInstance() : RetrofitService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}