package com.example.retrofitdemo.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitdemo.data.models.User
import com.example.retrofitdemo.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel constructor(private val repository: Repository)  : ViewModel() {

    private val _userList = MutableLiveData<List<User>>()

    val userList :LiveData<List<User>> = _userList

    val errorMessage = MutableLiveData<String>()

    fun getAllUsers() {
        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Main){
                val response = repository.getAllUsers()
                if (response.isSuccessful) {
                    _userList.postValue(response.body())
                } else {
                    errorMessage.postValue(response.message())
                }
            }
        }
    }
}