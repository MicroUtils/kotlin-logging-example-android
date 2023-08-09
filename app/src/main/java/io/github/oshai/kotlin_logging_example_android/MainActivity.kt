package io.github.oshai.kotlin_logging_example_android

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.github.oshai.kotlin_logging_example_android.ui.theme.KotlinloggingexampleandroidTheme
import io.github.oshai.kotlinlogging.KotlinLogging

object Static {
    init {
        System.setProperty("kotlin-logging-to-android-native", "true")
    }
}
private val static = Static

private val logger = KotlinLogging.logger {}

class MainActivity : ComponentActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinloggingexampleandroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }
        Log.v(TAG, "This is logging of - android.util.Log logging");
        logger.info { "This is logging of - kotlin-logging" }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinloggingexampleandroidTheme {
        Greeting("Android")
    }
}