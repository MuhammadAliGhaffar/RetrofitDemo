package com.example.retrofitdemo.repository

import com.example.retrofitdemo.data.models.User
import com.example.retrofitdemo.database.UserDatabase
import com.example.retrofitdemo.network.ApiState
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun allDatabaseUsers(): UserDatabase

    suspend fun getUser(): Flow<ApiState<List<User>?>>
}
