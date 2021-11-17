package com.example.retrofitdemo.repository

import com.example.retrofitdemo.data.models.User
import retrofit2.Response

interface Repository {
    suspend fun getAllUsers(): Response<List<User>>
}
