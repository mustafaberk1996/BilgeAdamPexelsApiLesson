package com.example.pexelapilesson.data.di

import com.example.pexelapilesson.data.repository.PhotoRepository
import com.example.pexelapilesson.data.repository.PhotoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


    @Provides
    fun providePhotoRepository(photoRepositoryImpl: PhotoRepositoryImpl): PhotoRepository = photoRepositoryImpl


}



