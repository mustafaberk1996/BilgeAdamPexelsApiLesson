package com.example.pexelapilesson.data.repository

import com.example.pexelapilesson.data.api.model.Photo
import com.example.pexelapilesson.data.api.service.PhotoService
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(
    private val photoService: PhotoService
):PhotoRepository {

    override suspend fun getAllPhotos(): List<Photo> {
        return photoService.getAllPhotos("animal").photos
    }
}