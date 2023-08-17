package com.example.pexelapilesson.data.repository

import com.example.pexelapilesson.data.api.model.Photo

interface PhotoRepository {

    suspend fun getAllPhotos():List<Photo>

}