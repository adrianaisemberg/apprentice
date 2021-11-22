package com.adrianaisemberg.apprentice

import com.adrianaisemberg.apprentice.databinding.ActivityMainBinding
import com.adrianaisemberg.apprentice.mvvm.ViewModelActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity :
    ViewModelActivity<MainActivityViewModel, ActivityMainBinding>(R.layout.activity_main)