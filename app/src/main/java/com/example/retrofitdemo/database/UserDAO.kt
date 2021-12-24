package com.example.retrofitdemo.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.retrofitdemo.data.models.User

@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(list: List<User>)

    @Query("SELECT * FROM tbl_user")
    suspend fun getUser(): List<User>
}
