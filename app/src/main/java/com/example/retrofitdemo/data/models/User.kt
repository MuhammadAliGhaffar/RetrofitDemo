package com.example.retrofitdemo.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "tbl_user")
data class User(
    @PrimaryKey
    @SerializedName("id")
    val id: Long?,
    @SerializedName("login")
    val username: String?,
    @SerializedName("avatar_url")
    val avatarUrl: String?,
    @SerializedName("html_url")
    val profileUrl: String?,
    @SerializedName("starred_url")
    val starredUrl: String?
)
