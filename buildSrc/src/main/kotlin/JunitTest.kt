object JUnitTest {
    private const val junitVersion = "4.13.2"
    const val junit = "junit:junit:${junitVersion}"
}

object AndroidTest {
    const val junitExt = "1.1.5"
    const val junit = "androidx.test.ext:junit:${junitExt}"
    const val testRunner = "androidx.test.runner:1.1.0"
    const val testRules = "androidx.test.rules:1.1.0"
}

object MockTest {
    const val mockkVersion = "1.12.2"
    const val mockk = "io.mockk:mockk:${mockkVersion}"
}