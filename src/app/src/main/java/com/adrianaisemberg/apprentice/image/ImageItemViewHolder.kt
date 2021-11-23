package com.adrianaisemberg.apprentice.image

import androidx.recyclerview.widget.RecyclerView
import com.adrianaisemberg.apprentice.databinding.ViewImageItemBinding
import com.adrianaisemberg.apprentice.navigation.Navigation
import com.adrianaisemberg.apprentice.service.ImageResult

class ImageItemViewHolder(
    private val binding: ViewImageItemBinding,
    private val navigation: Navigation,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(imageResult: ImageResult) {
        binding.viewModel = ImageItemViewModel(imageResult, navigation)
    }
}
