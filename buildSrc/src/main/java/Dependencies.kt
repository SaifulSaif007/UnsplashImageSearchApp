import org.gradle.api.artifacts.dsl.DependencyHandler

object BuildPlugins {
    val android by lazy { "com.android.tools.build:gradle:${Versions.gradlePlugin}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}" }

}

object Deps {
    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}" }
    val gson by lazy { "com.squareup.retrofit2:converter-gson:${Versions.retrofit}" }
}

fun DependencyHandler.retrofit() {
    implementation(Deps.retrofit)
    implementation(Deps.gson)
}

fun DependencyHandler.implementation(depName: String) {
    add("implementation", depName)
}

private fun DependencyHandler.kapt(depName: String) {
    add("kapt", depName)
}

private fun DependencyHandler.compileOnly(depName: String) {
    add("compileOnly", depName)
}

private fun DependencyHandler.api(depName: String) {
    add("api", depName)
}