package dev.ajkueterman.testharness

import androidx.lifecycle.ViewModel

@Suppress("unused")// MainViewModel is used as an example
class MainViewModel(
    val dependency: String
) : ViewModel()