plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("kotlin-kapt") // Enables KAPT for annotation processing
}

android {
    namespace = "com.example.mob"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mob"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_17  // Update to Java 17 if possible
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3" // Update to match the latest Compose Compiler version
    }
}



dependencies {
    // AndroidX core libraries
    implementation("androidx.core:core-ktx:1.12.0") // Update to latest stable version
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2") // Latest stable version
    implementation("androidx.activity:activity-compose:1.7.2") // Latest stable version

    // Compose UI libraries
    implementation("androidx.compose.ui:ui:1.5.3") // Latest Compose version
    implementation("androidx.compose.ui:ui-tooling-preview:1.5.3")
    implementation("androidx.compose.ui:ui-tooling:1.5.3") // Only for debugging, safe in release builds
    implementation("androidx.compose.foundation:foundation:1.5.3")
    implementation("androidx.compose.material3:material3:1.1.0") // Latest stable Material3 version
    implementation("androidx.datastore:datastore-preferences:1.0.0")
    implementation ("androidx.recyclerview:recyclerview:1.2.1")
    implementation ("androidx.compose.ui:ui:1.0.5")
    implementation ("androidx.compose.material:material:1.0.5")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.0.5")
    debugImplementation ("androidx.compose.ui:ui-tooling:1.0.5")





    // Material icons
    implementation("androidx.compose.material:material-icons-extended:1.5.3") // Update to match Compose version

    // Testing dependencies
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.5.3") // Match with Compose version
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.5.3") // Match with Compose version

}
