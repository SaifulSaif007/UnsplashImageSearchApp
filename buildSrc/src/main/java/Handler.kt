import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.core() {
    implementation(Dependencies.kotlinStdLib)
    implementation(Dependencies.ktx)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.material)
    implementation(Dependencies.constraintLayout)
}

fun DependencyHandler.retrofit() {
    implementation(Dependencies.retrofit)
    implementation(Dependencies.gson)
}

fun DependencyHandler.hilt() {
    implementation(Dependencies.hilt)
    kapt(Dependencies.hiltAnnotation)
}

fun DependencyHandler.navigation() {
    implementation(Dependencies.navigationFragment)
    implementation(Dependencies.navigationUi)
}

fun DependencyHandler.mixed() {
    implementation(Dependencies.glide)
    implementation(Dependencies.paging)
    implementation(Dependencies.dataStore)
}

fun DependencyHandler.leakCanary() {
    dedugImplementation(Dependencies.leakCanary)
}

fun DependencyHandler.implementation(depName: String) {
    add("implementation", depName)
}

fun DependencyHandler.dedugImplementation(depName: String) {
    add("debugImplementation", depName)
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