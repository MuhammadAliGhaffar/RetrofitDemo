package com.example.retrofitdemo.data.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("login")
    val username: String,
    @SerializedName("avatar_url")
    val avatarUrl: String,
    @SerializedName("html_url")
    val profileUrl: String,
    @SerializedName("starred_url")
    val starredUrl: String
)
