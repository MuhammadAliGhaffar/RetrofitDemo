package com.example.retrofitdemo.module

import com.example.retrofitdemo.repository.Repository
import com.example.retrofitdemo.repository.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {
    @Binds
    fun mainRepository(repositoryImpl: RepositoryImpl): Repository
}
