package com.example.retrofitdemo.repository

import com.example.retrofitdemo.data.models.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface UserDAO {

    @GET("users")
    fun getAllUsers() : Call<List<User>>

    companion object RemoteDatabase {

        var userDAO: UserDAO? = null
        var BaseUrl = "https://api.github.com/"

        fun getInstance() : UserDAO {

            if (userDAO == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                userDAO = retrofit.create(UserDAO::class.java)
            }
            return userDAO!!
        }
    }
}