package com.adrianaisemberg.apprentice.image

import com.adrianaisemberg.apprentice.R
import com.adrianaisemberg.apprentice.databinding.ViewImageItemBinding
import com.adrianaisemberg.apprentice.recycler_view.ItemsRecyclerAdapter
import com.adrianaisemberg.apprentice.service.ImageResult
import com.adrianaisemberg.apprentice.service.ImageSearchResults

class ImagesRecyclerAdapter :
    ItemsRecyclerAdapter<ImageItemViewHolder, ViewImageItemBinding>(R.layout.view_image_item) {

    private val items = mutableListOf<ImageResult>()

    fun setInitialResult(result: ImageSearchResults) {
        items.addAll(result.photos)
    }

    override fun createViewHolder(binding: ViewImageItemBinding): ImageItemViewHolder {
        return ImageItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
