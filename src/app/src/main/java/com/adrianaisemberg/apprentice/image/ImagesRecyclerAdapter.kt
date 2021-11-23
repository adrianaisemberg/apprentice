package com.adrianaisemberg.apprentice.image

import com.adrianaisemberg.apprentice.R
import com.adrianaisemberg.apprentice.databinding.ViewImageItemBinding
import com.adrianaisemberg.apprentice.navigation.Navigation
import com.adrianaisemberg.apprentice.recycler_view.ItemsRecyclerAdapter
import com.adrianaisemberg.apprentice.service.API
import com.adrianaisemberg.apprentice.service.ImageResult
import com.adrianaisemberg.apprentice.service.enqueue

class ImagesRecyclerAdapter(
    private val api: API,
    private val navigation: Navigation,
) : ItemsRecyclerAdapter<ImageItemViewHolder, ViewImageItemBinding>(R.layout.view_image_item) {

    private val items = mutableListOf<ImageResult>()
    private var currentPageIndex: Int = 0
    private var currentSearchTerm: String = ""

    override fun createViewHolder(binding: ViewImageItemBinding): ImageItemViewHolder {
        return ImageItemViewHolder(binding, navigation)
    }

    override fun onBindViewHolder(holder: ImageItemViewHolder, position: Int) {
        holder.bind(items[position])
        if (position == items.size - 1) {
            loadNextPage()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun search(text: String) {
        reset()
        currentSearchTerm = text
        if (currentSearchTerm.isNotEmpty()) {
            loadNextPage()
        }
    }

    private fun reset() {
        val previousCount = itemCount
        items.clear()
        notifyItemRangeRemoved(0, previousCount)
    }

    private fun loadNextPage() {
        api.searchImages(
            query = currentSearchTerm,
            perPage = PAGE_SIZE,
            page = currentPageIndex + 1,
        ).enqueue {
            val results = it.body() ?: return@enqueue
            currentPageIndex = results.page
            val previousItemCount = itemCount
            items.addAll(results.photos)
            notifyItemRangeInserted(previousItemCount, results.photos.size)
        }
    }

    companion object {
        private const val PAGE_SIZE = 30
    }
}
