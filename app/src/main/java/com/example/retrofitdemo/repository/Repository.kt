package com.example.retrofitdemo.repository

import com.example.retrofitdemo.data.models.User
import com.example.retrofitdemo.room.UserDatabase
import retrofit2.Response

interface Repository {
    suspend fun getAllNetworkUsers(): Response<List<User>>

    fun allDatabaseUsers(): UserDatabase
}
