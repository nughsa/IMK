plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "com.example.projekimk"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.projekimk"
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    // Core library AndroidX
    implementation ("androidx.core:core:1.13.0")
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("androidx.annotation:annotation:1.6.0")

// Material Design
    implementation ("com.google.android.material:material:1.11.0")

// Lifecycle and ViewModel
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")

// Constraint Layout
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")

// RecyclerView
    implementation ("androidx.recyclerview:recyclerview:1.3.1")

// Optional: jika Anda menggunakan Room atau database lainnya
    implementation ("androidx.room:room-runtime:2.5.2")
    annotationProcessor ("androidx.room:room-compiler:2.5.2")

// Optional: jika Anda menggunakan Navigation Component
    implementation ("androidx.navigation:navigation-fragment-ktx:2.7.3")
    implementation ("androidx.navigation:navigation-ui-ktx:2.7.3")

    // RxJava3
    implementation ("io.reactivex.rxjava3:rxjava:3.1.5")

// RxAndroid3 untuk AndroidSchedulers
    implementation ("io.reactivex.rxjava3:rxandroid:3.0.2")

    // Dependensi untuk pengujian Android Instrumented Tests
    androidTestImplementation ("androidx.test:core:1.4.0")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")



}
