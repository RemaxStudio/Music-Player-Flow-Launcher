// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.room) apply false
    alias(libs.plugins.google.ksp) apply false
    alias(libs.plugins.google.gms.google.services) apply false
    alias(libs.plugins.google.firebase.crashlytics) apply false
}

val useGoogleChannelConfig = gradle.startParameter.taskNames.any { it.contains("google", ignoreCase = true) }
extra["useGoogleChannelConfig"] = useGoogleChannelConfig
apply(from = if (useGoogleChannelConfig) "scripts/official.gradle" else "scripts/internal.gradle")
