plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
}

android {
    compileSdk  = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = "com.saiful.unsplashimagesearchapp"
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdk
        versionCode = ConfigData.versionCode
        versionName  = ConfigData.versionName

        testInstrumentationRunner =  "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.10")
    implementation("androidx.core:core-ktx:1.5.0")
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")

    testImplementation("junit:junit:4.+")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")

    // Navigation Component
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.5")

    // Dagger Hilt
    implementation("com.google.dagger:hilt-android:2.36")
    kapt("com.google.dagger:hilt-android-compiler:2.36")
    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    kapt("androidx.hilt:hilt-compiler:1.0.0-alpha03")

    retrofit()

    // Glide
    implementation("com.github.bumptech.glide:glide:4.11.0")

    // Paging 3
    implementation("androidx.paging:paging-runtime-ktx:3.0.0-alpha05")

    //Data Store Preferences
    implementation("androidx.datastore:datastore-preferences:1.0.0-beta02")
}
kapt {
    correctErrorTypes = true
}