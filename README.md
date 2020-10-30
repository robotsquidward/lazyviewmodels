# :sleeping: Lazy ViewModels

[![Android CI](https://github.com/robotsquidward/lazyviewmodels/workflows/Android%20CI/badge.svg)](https://github.com/robotsquidward/lazyviewmodels/actions?query=workflow%3A%22Android+CI%22)  [![Publish release](https://github.com/robotsquidward/lazyviewmodels/workflows/Publish%20release/badge.svg)](https://github.com/robotsquidward/lazyviewmodels/actions?query=workflow%3A%22Publish+release%22)

Convenient extensions built on top of the Android ViewModel Extensions library to enable easy ViewModel creation and Dependency Injection.

## :hammer_and_wrench:  Usage

These extensions create an Android ViewModel scoped to an Activity. 

### Basic Usage

When in an Activity (`ComponentActivity`):

```kotlin
private val viewModel: MyViewModel by lazyViewModels {
    MyViewModel(repo = MyRepository())  
}
```

When in a Fragment, create an Activity-scoped ViewModel with:

```kotlin
private val viewModel: MyViewModel by lazyActivityViewModels {
    MyViewModel(repo = MyRepository())  
}
```

### SavedStateHandle

To create a ViewModel that utilizes [`SavedStateHandle`](https://developer.android.com/reference/androidx/lifecycle/SavedStateHandle) via the constructor, use the Saved State versions of these extensions.

When in an Activity (`ComponentActivity`):

```kotlin
private val viewModel: MyViewModel by lazySavedStateViewModels { handle: SavedStateHandle ->
    MyViewModel(
        repo = MyRepository(),
        savedStateHandle = handle
    )
}
```

When in a Fragment, create an Activity-scoped View Model with: 

```kotlin
private val viewModel: MyViewModel by lazySavedStateActivityViewModels { handle: SavedStateHandle ->
    MyViewModel(
        repo = MyRepository(),
        savedStateHandle = handle
    )
}
```

Additionally, if you prefer to customize the [`SavedStateRegistryOwner`](https://developer.android.com/reference/androidx/savedstate/SavedStateRegistryOwner) that provides your `SavedStateHandle`, you can pass one in:

```kotlin
private val viewModel: MyViewModel by lazySavedStateActivityViewModels(this.requireActivity()) { handle: SavedStateHandle ->
    MyViewModel(
        repo = MyRepository(),
        savedStateHandle = handle
    )
}
```

[Check out my post on Android ViewModel Dependency Injection with extensions](https://ajkueterman.dev/posts/android-viewmodel-manual-dependency-injection-made-easy/) to learn more.

## :package:  Install

Packages are hosted in GitHub Packages. [Click here for Lazy ViewModels packages](https://github.com/robotsquidward/lazyviewmodels/packages).

GitHub Packages requires you to [authenticate to GitHub to install packages](https://docs.github.com/en/free-pro-team@latest/packages/using-github-packages-with-your-projects-ecosystem/configuring-gradle-for-use-with-github-packages#authenticating-to-github-packages). You can see an example setting up auth for this repo in the root [build.gradle](build.gradle).  In your `allProjects.repositories` block

```groovy
maven {
    name = "GitHubPackages"
    url = uri("https://maven.pkg.github.com/robotsquidward/lazyviewmodels")
    credentials {
        username = 'your username'
        password = 'your personal access token'
    }
}
```

Generate a [personal access token](https://docs.github.com/en/free-pro-team@latest/github/authenticating-to-github/creating-a-personal-access-token) with the permission for Reading from GitHub Packages and include it with your GitHub username. Then, include the dependency as normal

```groovy
dependencies {
    implementation 'dev.ajkueterman:lazyviewmodels:<version>'
}
```

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
