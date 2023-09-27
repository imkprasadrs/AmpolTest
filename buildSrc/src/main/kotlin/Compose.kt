object Compose {
    private const val composeVersion = "1.2.1"
    private const val composeActivitiesVersion = "1.3.1"
    private const val composeNavigationVersion = "2.5.3"
    private const val composeLifecycleVersion = "2.6.2"
    private const val materialVersion = "1.1.2"
    const val ui = "androidx.compose.ui:ui:${composeVersion}"
    const val material = "androidx.compose.material3:material3:${materialVersion}"
    const val uiTooling = "androidx.compose.ui:ui-tooling-preview:${composeVersion}"
    const val activity = "androidx.activity:activity-compose:${composeActivitiesVersion}"
    const val navigation = "androidx.navigation:navigation-compose:${composeNavigationVersion}"
    const val liveData = "androidx.compose.runtime:runtime-livedata:${composeVersion}"
    const val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-compose:${composeLifecycleVersion}"
}