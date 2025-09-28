package com.hobbydev.libraries.samples

import androidx.compose.runtime.Composable
import com.hobbydev.libraries.ui.AlphabetLetter

@Composable
private fun AlphabetLetterSelected(){
    AlphabetLetter(
        title ="A",
        selected = true,
        onLetterClick = { /* azione di esempio */ }
    )
}

@Composable
private fun AlphabetLetterUnselected(){
    AlphabetLetter(
        title ="A",
        selected = false,
        onLetterClick = { /* azione di esempio */ }
    )
}