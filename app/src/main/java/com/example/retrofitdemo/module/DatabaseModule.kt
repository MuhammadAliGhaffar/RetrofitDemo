package com.example.retrofitdemo.module

import android.content.Context
import androidx.room.Room
import com.example.retrofitdemo.room.UserDAO
import com.example.retrofitdemo.room.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    fun provideChannelDao(userDatabase: UserDatabase): UserDAO {
        return userDatabase.userDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): UserDatabase {
        return Room.databaseBuilder(
            context,
            UserDatabase::class.java,
            "userDB"
        ).build()
    }
}
