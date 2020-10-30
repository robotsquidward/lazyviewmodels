package dev.ajkueterman.lazyviewmodels

import androidx.activity.ComponentActivity
import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.savedstate.SavedStateRegistryOwner

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
inline fun <reified VM : ViewModel> ComponentActivity.lazyViewModels(
    noinline viewModelInitializer: () -> VM
): Lazy<VM> =
    ViewModelLazy(
        viewModelClass = VM::class,
        storeProducer = { viewModelStore },
        factoryProducer = {
            return@ViewModelLazy object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    @Suppress("UNCHECKED_CAST")// Casting T as ViewModel
                    return viewModelInitializer() as T
                }
            }
        }
    )

/**
 * An extension for [ComponentActivity] that provides a [ViewModel] by calling
 * [viewModelInitializer] with a lambda closure that provides a [SavedStateHandle] and returns your
 * custom [VM] class [ViewModel]. Returns a lazily instantiated [ViewModel] of your provided type
 * using an [AbstractSavedStateViewModelFactory].
 *
 * Like `by viewModels()`, this extension creates a [ViewModel] scoped to this [ComponentActivity].
 *
 * @param owner the [SavedStateRegistryOwner] used to provide the [SavedStateHandle], defaults
 * to this [ComponentActivity]
 * @param viewModelInitializer the lambda which returns your custom class [VM] of type [ViewModel]
 *
 * @return a [VM] class instantiated by [Lazy], scoped to the Activity
 */
@MainThread
inline fun <reified VM : ViewModel> ComponentActivity.lazySavedStateViewModels(
    owner: SavedStateRegistryOwner = this,
    noinline viewModelInitializer: (SavedStateHandle) -> VM
): Lazy<VM> =
    ViewModelLazy(
        viewModelClass = VM::class,
        storeProducer = { viewModelStore },
        factoryProducer = {
            return@ViewModelLazy object : AbstractSavedStateViewModelFactory(owner, null) {
                @Suppress("UNCHECKED_CAST")// Casting T as ViewModel
                override fun <T : ViewModel?> create(
                    key: String,
                    modelClass: Class<T>,
                    handle: SavedStateHandle
                ): T = viewModelInitializer(handle) as T
            }
        }
    )