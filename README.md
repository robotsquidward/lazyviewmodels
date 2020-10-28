# :sleeping: Lazy ViewModels

[![Android CI](https://github.com/robotsquidward/lazyviewmodels/workflows/Android%20CI/badge.svg)](https://github.com/robotsquidward/lazyviewmodels/actions?query=workflow%3A%22Android+CI%22)  [![Publish release](https://github.com/robotsquidward/lazyviewmodels/workflows/Publish%20release/badge.svg)](https://github.com/robotsquidward/lazyviewmodels/actions?query=workflow%3A%22Publish+release%22)

Convenient extensions built on top of the Android ViewModel Extensions library to enable easy ViewModel creation and Dependency Injection.

## :hammer_and_wrench:  Usage

These extensions create an Android `ViewModel` scoped to an Activity. 

When in an Activity (`ComponentActivity`):

```kotlin
private val viewModel: MyViewModel by viewModelBuilder {
    MyViewModel(repo = MyRepository())  
}
```

When in a Fragment, create an Activity-scoped ViewModel with:

```kotlin
private val viewModel: MyViewModel by activityViewModelBuilder {
    MyViewModel(repo = MyRepository())  
}
```

[Check out my post on Android ViewModel Dependency Injection with extensions](https://ajkueterman.dev/posts/android-viewmodel-manual-dependency-injection-made-easy/) to learn more.

## :package:  Install

[Click here for packages + import instructions](https://github.com/robotsquidward/lazyviewmodels/packages).
