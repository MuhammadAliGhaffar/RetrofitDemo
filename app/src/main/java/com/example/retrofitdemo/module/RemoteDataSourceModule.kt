package com.example.retrofitdemo.module

import com.example.retrofitdemo.network.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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
    fun provideRetrofitInstance(
        gsonConverterFactory: GsonConverterFactory,
        client: OkHttpClient
    ): RemoteDataSource {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(gsonConverterFactory)
            .client(client)
            .build()
            .create(RemoteDataSource::class.java)
    }

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptorInstance(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
    }

    @Singleton
    @Provides
    fun provideOkHttpClientInstance(logging: HttpLoggingInterceptor): OkHttpClient {
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC)
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    @Singleton
    @Provides
    fun provideGsonConverterFactoryInstance(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }
}
