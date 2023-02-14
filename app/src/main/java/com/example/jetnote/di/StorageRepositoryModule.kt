package com.example.jetnote.di

import com.example.core.data.NoteRepository
import com.example.jetnote.data.repository.NoteRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface StorageRepositoryModule {

    @Singleton
    @Binds
    fun bindStorageRepository(repository: NoteRepositoryImpl): NoteRepository
}