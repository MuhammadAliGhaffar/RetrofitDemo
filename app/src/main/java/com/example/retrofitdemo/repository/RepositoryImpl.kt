package com.example.retrofitdemo.repository

import com.example.retrofitdemo.Utils
import com.example.retrofitdemo.data.models.User
import com.example.retrofitdemo.database.UserDatabase
import com.example.retrofitdemo.network.ApiState
import com.example.retrofitdemo.network.RetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val retrofitService: RetrofitService,
    private val userDatabase: UserDatabase
) : Repository {
    override fun allDatabaseUsers() = userDatabase

    override suspend fun getUser(): Flow<ApiState<List<User>?>> {
        return flow {
            if (Utils.internetIsConnected()) {
                emit(ApiState.success(retrofitService.getAllUsers().body()))
            } else {
                emit(ApiState.success(userDatabase.userDao().getUser()))
            }
        }.flowOn(Dispatchers.IO)
    }
}
