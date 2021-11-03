package com.example.retrofitdemo.repository

class Repository constructor(private val userDAO: UserDAO) {
    fun getAllUsers() = userDAO.getAllUsers()
}