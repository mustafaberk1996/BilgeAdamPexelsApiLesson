package com.example.pexelapilesson.ui.main

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.pexelapilesson.data.api.model.Photo
import com.example.pexelapilesson.data.state.PhotoListState
import com.example.pexelapilesson.databinding.ActivityMainBinding
import com.example.pexelapilesson.ui.photoDetail.PhotoDetailFragment
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //getPhotos
        viewModel.getAllPhotos()

        observePhotoListState()


    }

    private fun onClick(photo: Photo){
        val photoDetailFragment = PhotoDetailFragment(photo)
        photoDetailFragment.show(supportFragmentManager,null)

    }

    private fun observePhotoListState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED){
                viewModel.photoListState.collect{
                    when(it){
                        is PhotoListState.Idle->{}
                        is PhotoListState.Loading->{
                            binding.rvPhotos.isVisible = false
                            binding.progressBar.isVisible = true
                        }
                        is PhotoListState.Empty->{
                            binding.rvPhotos.isVisible = false
                            binding.progressBar.isVisible = false
                        }
                        is PhotoListState.Result->{
                            binding.rvPhotos.isVisible = true
                            binding.progressBar.isVisible = false
                            binding.rvPhotos.adapter = PhotoAdapter(this@MainActivity, it.photos, this@MainActivity::onClick)
                        }
                        is PhotoListState.Error->{
                            binding.rvPhotos.isVisible = false
                            binding.progressBar.isVisible = false
                            Snackbar.make(binding.rvPhotos,"Bir hata olustu",Snackbar.LENGTH_LONG).show()
                        }
                    }
                }
            }
        }
    }
}