package com.example.retrofitdemo.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitdemo.data.models.User

class ItemViewModel : ViewModel() {
    val user = MutableLiveData<User>()
}
