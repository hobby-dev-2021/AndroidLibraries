package com.hobbydev.libraries.samples

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.hobbydev.libraries.ui.CustomInputField

@Composable
private fun CustomInputFieldSimple() {
    var text by remember { mutableStateOf("") }
    CustomInputField(
        value = text,
        onValueChange = { text = it },
        label = android.R.string.ok
    )
}

@Composable
private fun CustomInputFieldFull() {
    var text by remember { mutableStateOf("") }

    CustomInputField(
        value = text,
        onValueChange = { newText -> text = newText },
        enabled = true,
        label = android.R.string.ok,
        singleLine = true
    )
}