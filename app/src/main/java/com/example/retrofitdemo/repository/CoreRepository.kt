package com.example.retrofitdemo.repository

import com.example.retrofitdemo.data.models.User
import com.example.retrofitdemo.database.LocalDataSource
import com.example.retrofitdemo.network.ApiState
import kotlinx.coroutines.flow.Flow

interface CoreRepository {
    fun allDatabaseUsers(): LocalDataSource

    suspend fun getUser(): Flow<ApiState<List<User>?>>
}
