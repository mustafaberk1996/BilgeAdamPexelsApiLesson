package com.example.pexelapilesson.ui.photoDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import coil.load
import com.example.pexelapilesson.data.api.model.Photo
import com.example.pexelapilesson.databinding.FragmentPhotoDetailBinding
import com.example.pexelapilesson.percentage
import com.example.pexelapilesson.windowHeight
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class PhotoDetailFragment(private val photo: Photo) : BottomSheetDialogFragment() {

    lateinit var binding: FragmentPhotoDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPhotoDetailBinding.inflate(layoutInflater,container,false)
        binding.root.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, requireActivity().windowHeight().percentage(99))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivPhoto.load(photo.src.portrait)
        binding.tvPhotographer.text = photo.photographer


    }

}