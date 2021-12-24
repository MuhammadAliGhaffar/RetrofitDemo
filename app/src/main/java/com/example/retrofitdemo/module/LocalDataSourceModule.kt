package com.example.retrofitdemo.module

import android.content.Context
import androidx.room.Room
import com.example.retrofitdemo.database.LocalDataSource
import com.example.retrofitdemo.database.UserDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class LocalDataSourceModule {
    @Provides
    fun provideChannelDao(localDataSource: LocalDataSource): UserDAO {
        return localDataSource.userDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): LocalDataSource {
        return Room.databaseBuilder(
            context,
            LocalDataSource::class.java,
            "userDB"
        ).build()
    }
}
