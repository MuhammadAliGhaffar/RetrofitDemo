package com.example.retrofitdemo.repository

class Repository constructor(private val retrofitService: RetrofitService) {
    fun getAllUsers() = retrofitService.getAllUsers()
}