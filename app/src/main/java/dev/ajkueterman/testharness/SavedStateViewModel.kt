package dev.ajkueterman.testharness

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

@Suppress("unused")// SavedStateViewModel is used as an example
class SavedStateViewModel(
    val dependency: String,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel()