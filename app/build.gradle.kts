plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

}

android {
    namespace = "com.example.rnm_mvvm"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.rnm_mvvm"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    viewBinding {
        android.buildFeatures.viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.4")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Hilt - dagger
    implementation("com.google.dagger:hilt-android:2.35")
    //kapt("com.google.dagger:hilt-android-compiler:2.35")

    // To use by viewModels() in injection
    implementation("androidx.fragment:fragment-ktx:1.3.4")

    // RecyclerView
    implementation("androidx.recyclerview:recyclerview:1.2.0")

    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.7.1")
    implementation("com.google.code.gson:gson:2.8.6")

    implementation("com.squareup.okhttp3:logging-interceptor:4.4.0") // for cache

    // Coil for image loading
    implementation("io.coil-kt:coil:1.0.0")

    // ViewModel and LiveData
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.3")

    // To load NDK library
    implementation("com.getkeepsafe.relinker:relinker:1.4.3")

    //glide image nerwork
    implementation ("com.github.bumptech.glide:glide:4.16.0")
}