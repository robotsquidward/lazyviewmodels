package dev.ajkueterman.testharness

import androidx.activity.ComponentActivity
import dev.ajkueterman.lazyviewmodels.lazySavedStateViewModels
import dev.ajkueterman.lazyviewmodels.lazyViewModels

@Suppress("unused")// MainActivity is used as an example
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by lazyViewModels {
        MainViewModel("dep")
    }

    private val savedStateViewModel: SavedStateViewModel by lazySavedStateViewModels { savedStateHandle ->
        SavedStateViewModel(
            savedStateHandle = savedStateHandle,
            dependency = "saved state dep",
        )
    }
}