package dev.ajkueterman.testharness

import androidx.fragment.app.Fragment
import dev.ajkueterman.lazyviewmodels.activityViewModelBuilder

class MainFragment: Fragment() {

    private val viewModel: MainViewModel by activityViewModelBuilder {
        MainViewModel("de")
    }

}