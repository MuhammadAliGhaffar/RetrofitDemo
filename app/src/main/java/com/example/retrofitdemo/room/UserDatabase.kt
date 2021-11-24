package com.example.retrofitdemo.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.retrofitdemo.data.models.User

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDAO
}
