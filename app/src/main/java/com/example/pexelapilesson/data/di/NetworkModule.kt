package com.example.pexelapilesson.data.di

import com.example.pexelapilesson.Constants
import com.example.pexelapilesson.data.api.service.PhotoService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Provides
    fun provideRetrofit():Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun providePhotoService(retrofit: Retrofit):PhotoService = retrofit.create(PhotoService::class.java)


}