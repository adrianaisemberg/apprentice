package com.adrianaisemberg.apprentice.image

import com.adrianaisemberg.apprentice.R
import com.adrianaisemberg.apprentice.databinding.ActivityImageViewerBinding
import com.adrianaisemberg.apprentice.mvvm.ViewModelActivity
import dagger.hilt.android.AndroidEntryPoint

/**
 * an activity for displaying an image
 */
@AndroidEntryPoint
class ImageViewerActivity :
    ViewModelActivity<ImageViewerViewModel, ActivityImageViewerBinding>(R.layout.activity_image_viewer)
