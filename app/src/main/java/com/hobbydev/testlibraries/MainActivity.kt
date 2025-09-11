package com.hobbydev.testlibraries


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.hobbydev.libraries.ui.AlphabetLetter
import com.hobbydev.libraries.ui.CustomSnackbar
import com.hobbydev.libraries.ui.Example
import com.hobbydev.libraries.ui.Flag
import com.hobbydev.libraries.ui.IndexButton
import com.hobbydev.libraries.ui.Rule
import com.hobbydev.testlibraries.theme.ui.AndroidLibrariesTheme
import com.hobbydev.libraries.ui.Title
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidLibrariesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column {
        Title(text = "Hello $name!")
        Example(text = buildAnnotatedString {
            append("questo è un esempio di testo semplice")
        })

        Rule("regola con testo semplice")
        Rule( text = buildAnnotatedString {
            append("questo è un esempio di regola che contiene un ")
            withStyle(style = SpanStyle(fontWeight = FontWeight. Bold)) {
                append("testo complesso")
            }
        })
        IndexButton(
            onClick = { /*TODO*/ },
            stringResourseId = R.string.app_name,
            descriptionResourseId = R.string.app_name,
            icon = Icons.Filled.Build
        )
        Row {
            AlphabetLetter(
                title = "A",
                selected = true,
                onLetterClick = {}
            )
            AlphabetLetter(
                title = "B",
                selected = false,
                onLetterClick = {}
            )
        }
        Flag(
            flagResId = android.R.drawable.arrow_up_float,
            onFlagClick = {}
        )
        val snackbarHostState = remember { SnackbarHostState() }
        val scope = rememberCoroutineScope()
        Scaffold(
            snackbarHost = {
                SnackbarHost(snackbarHostState) { data ->
                    CustomSnackbar(data)
                }
            }
        ) { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                Button(onClick =
                {
                    scope.launch {
                        snackbarHostState.showSnackbar("Esempio di messaggio")
                    }
                }
                ) {
                    Text("Mostra Snackbar")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidLibrariesTheme {
        Greeting("Android")
    }
}