plugins {
    id(Plugins.androidApplication)
    kotlin(KotlinPlugins.android)
    kotlin(KotlinPlugins.kapt)
    id(Plugins.hilt)
}

android {
    namespace = Application.appId
    compileSdk = Application.compileSdk
    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        applicationId = Application.appId
        minSdk = Application.minSdk
        targetSdk = Application.compileSdk
        versionCode = Application.versionCode
        versionName = Application.versionName
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        named("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Kotlin.kotlinCompilerExtensionVersion
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(Kotlin.kotlin)
    implementation(Kotlin.coreKtx)
    implementation(Compose.activity)
    implementation(Compose.ui)
    implementation(Compose.uiTooling)
    implementation(Compose.material)
    implementation(Compose.navigation)
    implementation(Compose.lifecycleViewModel)
    implementation(Compose.liveData) // not required - remove it
    kapt(Hilt.hiltCompiler)
    implementation(Hilt.hiltAndroid)
    implementation(Hilt.hiltNavigation)
    implementation(SquareUp.retrofit)
    implementation(SquareUp.retrofitConverter)
    implementation(SquareUp.httpLogging)
    testImplementation(JUnitTest.junit)
    testImplementation(MockTest.mockk)
}