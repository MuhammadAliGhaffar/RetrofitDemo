package com.example.retrofitdemo.repository

class Repository constructor(private val retrofitService: RetrofitService) {
    suspend fun getAllUsers() = retrofitService.getAllUsers()
}