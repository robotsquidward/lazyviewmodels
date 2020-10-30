package dev.ajkueterman.testharness

import androidx.appcompat.app.AppCompatActivity
import dev.ajkueterman.lazyviewmodels.lazySavedStateViewModels
import dev.ajkueterman.lazyviewmodels.lazyViewModels

class MainActivity: AppCompatActivity() {

    private val viewModel: MainViewModel by lazyViewModels {
        MainViewModel("dep")
    }

    private val savedStateViewModel: SavedStateViewModel by lazySavedStateViewModels { savedStateHandle ->
        SavedStateViewModel(savedStateHandle = savedStateHandle)
    }

}