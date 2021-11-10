package com.example.retrofitdemo.repository

import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val retrofitService: RetrofitService): Repository {
    override suspend fun getAllUsers() = retrofitService.getAllUsers()
}