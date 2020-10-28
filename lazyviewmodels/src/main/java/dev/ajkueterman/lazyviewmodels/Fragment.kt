package dev.ajkueterman.lazyviewmodels

import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelLazy
import androidx.lifecycle.ViewModelProvider

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
inline fun <reified VM : ViewModel> Fragment.activityViewModelBuilder(
    noinline viewModelInitializer: () -> VM
): Lazy<VM> =
    ViewModelLazy(
        viewModelClass = VM::class,
        storeProducer = { requireActivity().viewModelStore },
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    @Suppress("UNCHECKED_CAST")// Casting T as ViewModel
                    return viewModelInitializer.invoke() as T
                }
            }
        }
    )