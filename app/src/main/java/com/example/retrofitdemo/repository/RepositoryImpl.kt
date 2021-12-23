package com.example.retrofitdemo.repository

import com.example.retrofitdemo.Utils
import com.example.retrofitdemo.data.models.User
import com.example.retrofitdemo.room.UserDatabase
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val retrofitService: RetrofitService,
    private val userDatabase: UserDatabase
) : Repository {
    override suspend fun getAllNetworkUsers() = retrofitService.getAllUsers()

    override fun allDatabaseUsers() = userDatabase

    override suspend fun loadUser(): List<User>? {
        return if (Utils.internetIsConnected())
            retrofitService.getAllUsers().body()
        else
            userDatabase.userDao().getUser()
    }
}
