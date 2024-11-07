plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
    alias(libs.plugins.jetbrainsKotlinSerialization)
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11
    }
}

dependencies {
    implementation(libs.retrofit.core)
    implementation(libs.kotlin.serialization)
    implementation(libs.okhttpLoggingInterceptor)
    implementation(libs.bundles.retrofit)
    implementation(libs.koin.core)
}