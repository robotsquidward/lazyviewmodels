plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 35
    buildToolsVersion = "35.0.0"

    defaultConfig {
        namespace = "dev.ajkueterman.testharness"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}

dependencies {
    implementation("androidx.activity:activity-ktx:1.10.1")
    implementation("androidx.fragment:fragment-ktx:1.8.6")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.1.21")
    implementation("androidx.core:core-ktx:1.16.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.9.0")

    // Test pull of library from GitHub Packages
    //implementation("dev.ajkueterman:lazyviewmodels:0.0.3")

    // Pull directly from local library for test harness development
    implementation(project(":lazyviewmodels"))

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
}