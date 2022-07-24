// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(BuildPlugins.android)
        classpath(BuildPlugins.kotlin)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files

        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.3.5")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.36")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class){
    delete(rootProject.buildDir)
}