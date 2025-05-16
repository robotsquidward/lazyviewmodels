package dev.ajkueterman.lazyviewmodels

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.savedstate.SavedStateRegistryOwner

/**
 * An extension on [Fragment] that provides a [ViewModel] by calling [activityViewModelBuilder]
 * with a lambda closure that returns your custom [VM] class [ViewModel]. Returns a lazily
 * instantiated [ViewModel] of your provided type using a [ViewModelProvider].
 *
 * Like `by activityViewModels()`, this extension creates a [ViewModel] scoped to the Activity.
 *
 * @param viewModelInitializer the lambda which returns your custom class [VM] of type [ViewModel]
 *
 * @return a [VM] class instantiated by [Lazy], scoped to the Activity
 */
@MainThread
inline fun <reified VM : ViewModel> Fragment.lazyActivityViewModels(
    noinline viewModelInitializer: () -> VM
): Lazy<VM> =
    ViewModelLazy(
        viewModelClass = VM::class,
        storeProducer = { requireActivity().viewModelStore },
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    @Suppress("UNCHECKED_CAST")// Casting T as ViewModel
                    return viewModelInitializer() as T
                }
            }
        }
    )

/**
 * An extension for [Fragment] that provides a [ViewModel] by calling
 * [viewModelInitializer] with a lambda closure that provides a [SavedStateHandle] and returns your
 * custom [VM] class [ViewModel]. Returns a lazily instantiated [ViewModel] of your provided type
 * using an [AbstractSavedStateViewModelFactory].
 *
 * Like `by activityViewModels()`, this extension creates a [ViewModel] scoped to the parent
 * [ComponentActivity].
 *
 * @param owner the [SavedStateRegistryOwner] for this [ViewModel], typically a Fragment or Activity.
 * @param defaultArgs the default arguments to pass to the [SavedStateHandle].
 * @param viewModelInitializer the lambda which returns your custom class [VM] of type [ViewModel]
 *
 * @return a [VM] class instantiated by [Lazy], scoped to the Activity
 */
@MainThread
inline fun <reified VM : ViewModel> Fragment.lazySavedStateActivityViewModels(
    owner: SavedStateRegistryOwner = this,
    defaultArgs: Bundle? = null,
    noinline viewModelInitializer: (SavedStateHandle) -> VM
): Lazy<VM> =
    ViewModelLazy(
        viewModelClass = VM::class,
        storeProducer = { requireActivity().viewModelStore },
        factoryProducer = {
            return@ViewModelLazy object : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
                @Suppress("UNCHECKED_CAST")// Casting T as ViewModel
                override fun <T : ViewModel> create(
                    key: String,
                    modelClass: Class<T>,
                    handle: SavedStateHandle
                ): T = viewModelInitializer(handle) as T
            }
        }
    )