package com.example.retrofitdemo.module

import com.example.retrofitdemo.network.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataSourceModule(
    private val baseUrl: String = "https://api.github.com/"
) {

    @Singleton
    @Provides
    fun provideRetrofitInstance(gsonConverterFactory: GsonConverterFactory): RemoteDataSource {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(gsonConverterFactory)
            .build()
            .create(RemoteDataSource::class.java)
    }

    @Singleton
    @Provides
    fun provideGsonConverterFactoryInstance(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }
}
