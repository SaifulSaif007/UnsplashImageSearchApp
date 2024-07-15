plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

gradlePlugin {
//    plugins {
//        register("common-module-plugin") {
//            id = "common-module-plugin"
//            implementationClass = "CommonModulePlugin"
//        }
//    }
}

repositories {
    mavenCentral()
    google()
}

dependencies {
    compileOnly(gradleApi())
    implementation("com.android.tools.build:gradle:8.0.0")
    implementation(kotlin("gradle-plugin", "1.7.0"))
}