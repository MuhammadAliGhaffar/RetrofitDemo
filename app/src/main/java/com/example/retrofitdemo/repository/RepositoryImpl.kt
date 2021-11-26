package com.example.retrofitdemo.repository

import com.example.retrofitdemo.room.UserDatabase
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val retrofitService: RetrofitService, private val userDatabase: UserDatabase) : Repository {
    override suspend fun getAllNetworkUsers() = retrofitService.getAllUsers()

    override fun allDatabaseUsers() = userDatabase
}
