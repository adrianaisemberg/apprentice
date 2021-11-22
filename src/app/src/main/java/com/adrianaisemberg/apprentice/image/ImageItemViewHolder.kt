package com.adrianaisemberg.apprentice.image

import androidx.recyclerview.widget.RecyclerView
import com.adrianaisemberg.apprentice.databinding.ViewImageItemBinding
import com.adrianaisemberg.apprentice.service.ImageResult

class ImageItemViewHolder(
    private val binding: ViewImageItemBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(imageResult: ImageResult) {
        binding.viewModel = imageResult
    }
}
