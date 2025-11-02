package com.hobbydev.libraries.samples

import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hobbydev.libraries.ui.Title

@Composable
private fun TitleSimple(){
    Title("Questo è un titolo senza sfondo")
}

@Composable
private fun TitleWithBackgroundColor(){
    Title(
        text = "Titolo con lo sfondo di default",
        backgroundColor = true
    )
}
