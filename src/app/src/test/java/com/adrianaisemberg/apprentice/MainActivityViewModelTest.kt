package com.adrianaisemberg.apprentice

import android.app.Activity
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.adrianaisemberg.apprentice.navigation.Navigation
import com.adrianaisemberg.apprentice.service.API
import com.adrianaisemberg.apprentice.utils.TimerThrottler
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class MainActivityViewModelTest {

    // allow testing with LiveData
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Test
    fun onTextChanged_emptyText_cannotClear() {
        onTextChanged("", false)
    }

    @Test
    fun onTextChanged_nonEmptyText_canClear() {
        onTextChanged("cats", true)
    }

    @Test
    fun onTextChanged_invokeTimer() {
        val activity = Activity()
        val api = mock<API>()
        val navigation = mock<Navigation>()
        val timer = mock<TimerThrottler>()

        val mainActivityViewModel = MainActivityViewModel(
            activity = activity,
            api = api,
            navigation = navigation,
            timer = timer
        )

        mainActivityViewModel.onTextChanged("cats")

        verify(timer).runAfter(any(), any())
    }

    private fun onTextChanged(text: String, canClear: Boolean) {
        val activity = Activity()
        val api = mock<API>()
        val navigation = mock<Navigation>()
        val timer = mock<TimerThrottler>()

        val mainActivityViewModel = MainActivityViewModel(
            activity = activity,
            api = api,
            navigation = navigation,
            timer = timer
        )

        mainActivityViewModel.onTextChanged(text)

        Assert.assertEquals(canClear, mainActivityViewModel.canClear.value)
    }
}