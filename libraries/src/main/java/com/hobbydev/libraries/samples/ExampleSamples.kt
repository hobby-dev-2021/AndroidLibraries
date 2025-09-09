package com.hobbydev.libraries.samples

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.hobbydev.libraries.ui.Example

@Composable
fun ExampleWithoutTitle(){
    Example(
        text = buildAnnotatedString {
            append("questo è un esempio di testo semplice senza titolo")
        }
    )
}

@Composable
fun ExampleWithTitle(){
    Example(
        text = buildAnnotatedString {
            append("questo è un esempio di testo ")
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append("completo con il titolo")
            }
        },
        title = "titolo"
    )
}
