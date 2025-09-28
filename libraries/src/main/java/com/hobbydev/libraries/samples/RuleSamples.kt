package com.hobbydev.libraries.samples

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.hobbydev.libraries.ui.Rule

@Composable
private fun RuleWithText(){
    Rule(
        text = "questo è un esempio di regola che contiene testo semplice"
    )
}

@Composable
private fun RuleWithAnnotatedText(){
    Rule(
        text = buildAnnotatedString {
            append("questo è un esempio di regola che contiene un ")
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append("testo complesso")
            }
        }
    )
}