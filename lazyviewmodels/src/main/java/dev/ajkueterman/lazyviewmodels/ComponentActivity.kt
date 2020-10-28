package dev.ajkueterman.lazyviewmodels

import androidx.activity.ComponentActivity
import androidx.annotation.MainThread
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelLazy
import androidx.lifecycle.ViewModelProvider

/**
 * An extension for [ComponentActivity] that provides a [ViewModel] by calling [viewModelBuilder]
 * with a lambda closure that returns your custom [VM] class [ViewModel]. Returns a lazily
 * instantiated [ViewModel] of your provided type using a [ViewModelProvider].
 *
 * Like `by viewModels()`, this extension creates a [ViewModel] scoped to this [ComponentActivity].
 *
 * @param viewModelInitializer the lambda which returns your custom class [VM] of type [ViewModel]
 *
 * @return a [VM] class instantiated by [Lazy], scoped to the Activity
 */
@MainThread
inline fun <reified VM : ViewModel> ComponentActivity.viewModelBuilder(
    noinline viewModelInitializer: () -> VM
): Lazy<VM> =
    ViewModelLazy(
        viewModelClass = VM::class,
        storeProducer = { viewModelStore },
        factoryProducer = {
            return@ViewModelLazy object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    @Suppress("UNCHECKED_CAST")// Casting T as ViewModel
                    return viewModelInitializer.invoke() as T
                }
            }
        }
    )
