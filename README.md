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

## :mailbox_with_mail: Contact

This project is solely maintained by [AJ](https://ajkueterman.dev) ([robotsquidward](https://robotsquidward.com)).

If you need to raise an issue or question about this library, please create an issue and tag it with a relevant label.

## :pencil2: Contributing

To get started, please fork the repo and checkout a new branch. You can then build the library code locally with the Gradle wrapper

```
./gradlew :lazyviewmodels:build
```

The library code is in the [/lazyviewmodels](/lazyviewmodels) directory. Feel free to commit code to the `:app` wrapper application to support changes to the library.

See more in [CONTRIBUTING](CONTRIBUTING.md)

## :balance_scale: License

This library is licensed under the [MIT License](LICENSE)
