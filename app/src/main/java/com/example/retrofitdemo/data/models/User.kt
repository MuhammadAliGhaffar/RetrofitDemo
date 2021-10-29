package com.example.retrofitdemo.data.models

import android.widget.RelativeLayout
import com.google.gson.annotations.SerializedName

class User {
    //@SerializedName("login")
    private lateinit var username: String

    //@SerializedName("avatar_url")
    private var avatar_url: Int

    //@SerializedName("html_url")
    private lateinit var profile_url: String

    //@SerializedName("starred_url")
    private lateinit var starred_url: String

    constructor(username: String, avatar_url: Int, profile_url: String, starred_url: String) {
        this.username = username
        this.avatar_url = avatar_url
        this.profile_url = profile_url
        this.starred_url = starred_url
    }

    fun getusername(): String = username

    fun getavatar_url(): Int = avatar_url

    fun getprofile_url(): String = profile_url

    fun getstarred_url(): String = starred_url

    override fun toString(): String {
        return "User(username='$username', avatar_url=$avatar_url, profile_url='$profile_url', starred_url='$starred_url')"
    }

}