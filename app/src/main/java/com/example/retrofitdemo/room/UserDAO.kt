package com.example.retrofitdemo.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.retrofitdemo.data.models.User

@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(list: List<User>)

    /**
     * Checking whether data is live or not so it will execute on background thread
     */
    @Query("SELECT * FROM tbl_user")
    fun getUser(): LiveData<List<User>>
}
