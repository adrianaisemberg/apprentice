package com.adrianaisemberg.apprentice.image

import androidx.lifecycle.MutableLiveData
import com.adrianaisemberg.apprentice.R
import com.adrianaisemberg.apprentice.databinding.ViewImageItemBinding
import com.adrianaisemberg.apprentice.navigation.Navigation
import com.adrianaisemberg.apprentice.recycler_view.ItemsRecyclerAdapter
import com.adrianaisemberg.apprentice.service.API
import com.adrianaisemberg.apprentice.service.ImageResult
import com.adrianaisemberg.apprentice.service.enqueue
import com.adrianaisemberg.apprentice.utils.async_ui

/**
 * a recycler adapter for loading and displaying image search results
 *
 * @property api the service API
 * @property navigation navigation
 */
class ImagesRecyclerAdapter(
    private val api: API,
    private val navigation: Navigation,
) : ItemsRecyclerAdapter<ImageItemViewHolder, ViewImageItemBinding>(R.layout.view_image_item) {

    /**
     * holds the search result items
     */
    private val items = mutableListOf<ImageResult>()

    /**
     * the current page index.
     * used for loading next pages
     */
    private var currentPageIndex: Int = 0

    /**
     * the current search term.
     * used for loading next pages
     */
    private var currentSearchTerm: String = ""

    /**
     * flag for controlling the loading-indicator visibility
     */
    var isLoading = MutableLiveData(false)

    /**
     * flag for controlling the error-indicator visibility
     */
    var isError = MutableLiveData(false)

    /**
     * the current error, if any
     */
    var errorText = MutableLiveData<String>(null)

    override fun createViewHolder(binding: ViewImageItemBinding): ImageItemViewHolder {
        return ImageItemViewHolder(binding, navigation)
    }

    override fun onBindViewHolder(holder: ImageItemViewHolder, position: Int) {
        holder.bind(items[position])
        if (position == items.size - 1) {
            // if binding the last item - load next page
            loadNextPage()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    /**
     * searches for the specified text
     *
     * @param text The search terms
     */
    fun search(text: String) {
        // first reset the list, removing all items
        reset()

        // store the current search term for loading next pages
        currentSearchTerm = text
        if (currentSearchTerm.isNotEmpty()) {
            async_ui {
                isLoading.value = true
                isError.value = false
                errorText.value = null
            }

            // load the first page
            loadNextPage()
        }
    }

    /**
     * resets the items list
     */
    private fun reset() {
        val previousCount = itemCount
        items.clear()
        notifyItemRangeRemoved(0, previousCount)
    }

    /**
     * loads the next page of search results
     */
    private fun loadNextPage() {
        api.searchImages(
            query = currentSearchTerm,
            perPage = PAGE_SIZE,
            page = currentPageIndex + 1,
        ).enqueue(
            onResponse = { response ->
                async_ui {
                    isLoading.value = false
                    isError.value = false
                    errorText.value = null
                }
                val results = response.body() ?: return@enqueue

                // The search results contain the current page index
                currentPageIndex = results.page

                // Save the previous count for inserted-range notification after adding the results
                val previousItemCount = itemCount

                items.addAll(results.photos)

                // notify the adapter about the inserted range
                notifyItemRangeInserted(previousItemCount, results.photos.size)
            },
            onFailure = { error ->
                async_ui {
                    isLoading.value = false
                    isError.value = true
                    errorText.value = error.message
                }
            }
        )
    }

    companion object {
        /**
         * search results page-size
         */
        private const val PAGE_SIZE = 30
    }
}
