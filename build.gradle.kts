plugins {
    id("com.android.application").version("8.0.1").apply(false)
    kotlin("android").version("1.8.21").apply(false)
}

buildscript{
    dependencies {
        classpath(Build.kotlinGradlePlugin)
        classpath(Build.buildTools)
        classpath(Build.hiltGradlePlugin)
    }
}