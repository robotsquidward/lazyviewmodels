package dev.ajkueterman.testharness

import androidx.fragment.app.Fragment
import dev.ajkueterman.lazyviewmodels.lazyActivityViewModels
import dev.ajkueterman.lazyviewmodels.lazySavedStateActivityViewModels

@Suppress("unused")// MainFragment is used as an example
class MainFragment : Fragment() {

    private val viewModel: MainViewModel by lazyActivityViewModels {
        MainViewModel("dep")
    }

    private val savedStateViewModel: SavedStateViewModel by lazySavedStateActivityViewModels { savedStateHandle ->
        SavedStateViewModel(
            savedStateHandle = savedStateHandle,
            dependency = "saved state dep",
        )
    }
}