package com.adrianaisemberg.apprentice

import com.adrianaisemberg.apprentice.image.ImageItemViewModel
import com.adrianaisemberg.apprentice.navigation.Navigation
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class ImageItemViewModelTest {

    @Test
    fun onClick_navigatesToImage() {
        val imageResult = createEmptyImageResult()

        val navigation = mock<Navigation>()
        val imageItemViewModel = ImageItemViewModel(imageResult, navigation)

        imageItemViewModel.onClick()

        verify(navigation).openImage(imageResult)
    }
}
