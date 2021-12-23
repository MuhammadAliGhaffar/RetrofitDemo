package com.example.retrofitdemo.repository

import com.example.retrofitdemo.Utils
import com.example.retrofitdemo.data.models.User
import com.example.retrofitdemo.database.LocalDataSource
import com.example.retrofitdemo.network.ApiState
import com.example.retrofitdemo.network.RemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CoreRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : CoreRepository {
    override fun allDatabaseUsers() = localDataSource

    override suspend fun getUser(): Flow<ApiState<List<User>?>> {
        return flow {
            if (Utils.internetIsConnected()) {
                emit(ApiState.success(remoteDataSource.getAllUsers().body()))
            } else {
                emit(ApiState.success(localDataSource.userDao().getUser()))
            }
        }.flowOn(Dispatchers.IO)
    }
}
