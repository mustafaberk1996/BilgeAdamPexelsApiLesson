package com.example.pexelapilesson.data.api.service

import com.example.pexelapilesson.Constants
import com.example.pexelapilesson.data.api.model.Photo
import com.example.pexelapilesson.data.api.model.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface PhotoService {

    @Headers(
        "Authorization: ${Constants.API_KEY}"
    )
    @GET("v1/search")
    suspend fun getAllPhotos(@Query("query") queryText:String):Response<List<Photo>>

}