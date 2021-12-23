package com.example.retrofitdemo.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitdemo.data.models.User
import com.example.retrofitdemo.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _userList = MutableLiveData<List<User>>()

    val userList: LiveData<List<User>> = _userList

    val errorMessage = MutableLiveData<String>()

    fun getAllUsers() {
        // Checking whether internet is available or not
        viewModelScope.launch {
            _userList.postValue(repository.loadUser())
        }
    }
}
