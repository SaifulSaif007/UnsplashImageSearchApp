object BuildPlugins {
    val android by lazy { "com.android.tools.build:gradle:${Versions.gradlePlugin}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}" }
    val safeArgs by lazy { "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.safeArgs}" }
    val hiltPlugin by lazy { "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}" }

}

object Dependencies {
    val kotlinStdLib by lazy { "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}" }
    val ktx by lazy { "androidx.core:core-ktx:${Versions.kotlin}" }
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
    val material by lazy { "com.google.android.material:material:${Versions.appCompat}" }
    val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" }

    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}" }
    val gson by lazy { "com.squareup.retrofit2:converter-gson:${Versions.retrofit}" }
    val hilt by lazy { "com.google.dagger:hilt-android:${Versions.hilt}" }
    val hiltAnnotation by lazy { "com.google.dagger:hilt-android-compiler:${Versions.hilt}" }
    val hiltViewModel by lazy { "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltViewModel}" }
    val hiltViewModelAnnotation by lazy { "androidx.hilt:hilt-compiler:${Versions.hiltViewModel}" }
    val navigationFragment by lazy { "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}" }
    val navigationUi by lazy { "androidx.navigation:navigation-ui-ktx:${Versions.navigation}" }
    val glide by lazy { "com.github.bumptech.glide:glide:${Versions.glide}" }
    val paging by lazy { "androidx.paging:paging-runtime-ktx:${Versions.paging}" }
    val dataStore by lazy { "androidx.datastore:datastore-preferences:${Versions.dataStore}" }

    val leakCanary by lazy { "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}" }

    val testJunit by lazy { "junit:junit:${Versions.testJunit}" }
    val androidTestJunit by lazy { "androidx.test.ext:junit:${Versions.androidTestJunit}" }
    val espressoCore by lazy { "androidx.test.espresso:espresso-core:${Versions.espressoCore}" }


}
