package com.example.retrofitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitdemo.repository.Repository
import com.example.retrofitdemo.repository.RetrofitService
import com.example.retrofitdemo.ui.viewModel.FactoryViewModel
import com.example.retrofitdemo.ui.viewModel.UserViewModel

class MainActivity : AppCompatActivity() {

    lateinit var userviewModel: UserViewModel
    private val retrofitService = RetrofitService.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        userviewModel = ViewModelProvider(this, FactoryViewModel(Repository(retrofitService))).get(UserViewModel::class.java)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}