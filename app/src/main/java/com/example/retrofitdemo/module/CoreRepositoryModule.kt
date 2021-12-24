package com.example.retrofitdemo.module

import com.example.retrofitdemo.repository.CoreRepository
import com.example.retrofitdemo.repository.CoreRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface CoreRepositoryModule {
    @Binds
    fun mainRepository(repositoryImpl: CoreRepositoryImpl): CoreRepository
}
