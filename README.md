# kotlin-logging-example-android

An example `Android` project for https://github.com/oshai/kotlin-logging

The relevant code to add kotlin-logging to your android app is:

in `app/build.gradle.kts`:

```kotlin
dependencies {
    implementation("io.github.oshai:kotlin-logging-android:5.0.2")
}
```

in `app/src/main/java/com/example/kotlinloggingexampleandroid/MainActivity.kt`:

```kotlin  

import io.github.oshai.kotlinlogging.KotlinLogging

// this part should be configured only once in the app to use native android logging
object Static {
    init {
        System.setProperty("kotlin-logging-to-android-native", "true")
    }
}
private val static = Static

// this should be configured in every class that uses logging
private val logger = KotlinLogging.logger {}

// then later in the code
logger.info { "This is logging of - kotlin-logging" }

```