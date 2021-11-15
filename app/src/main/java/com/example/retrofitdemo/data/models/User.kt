package com.example.retrofitdemo.data.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("login")
    val username: String,
    @SerializedName("avatar_url")
    val avatar_url: String,
    @SerializedName("html_url")
    val profile_url: String,
    @SerializedName("starred_url")
    val starred_url: String
)
