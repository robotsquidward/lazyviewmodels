package dev.ajkueterman.testharness

import androidx.appcompat.app.AppCompatActivity
import dev.ajkueterman.lazyviewmodels.viewModelBuilder

class MainActivity: AppCompatActivity() {

    private val viewModel: MainViewModel by viewModelBuilder {
        MainViewModel("dep")
    }

}