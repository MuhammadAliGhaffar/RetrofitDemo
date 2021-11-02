package com.example.retrofitdemo.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitdemo.data.models.User
import com.example.retrofitdemo.repository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel constructor(private val repository: Repository)  : ViewModel() {

    val userList = MutableLiveData<List<User>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllUsers() {

        val response = repository.getAllUsers()
        response.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                userList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}