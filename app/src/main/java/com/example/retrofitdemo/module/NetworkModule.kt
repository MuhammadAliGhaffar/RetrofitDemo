package com.example.retrofitdemo.module

import com.example.retrofitdemo.repository.RetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule(
    private var retrofitService: RetrofitService? = null,
    private val baseUrl: String = "https://api.github.com/"
) {

    @Singleton
    @Provides
    fun provideRetrofitInstance(): RetrofitService {
        if (retrofitService == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofitService = retrofit.create(RetrofitService::class.java)
        }
        return retrofitService!!
    }
}
