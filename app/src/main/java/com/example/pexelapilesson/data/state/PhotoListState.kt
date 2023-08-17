package com.example.pexelapilesson.data.state

import com.example.pexelapilesson.data.api.model.Photo

sealed class PhotoListState {
    object Idle : PhotoListState()
    object Loading : PhotoListState()
    object Empty : PhotoListState()
    class Result(val photos: List<Photo>) : PhotoListState()
    class Error(val throwable: Throwable? = null) : PhotoListState()
}
