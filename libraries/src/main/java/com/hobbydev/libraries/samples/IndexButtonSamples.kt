package com.hobbydev.libraries.samples

import android.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.hobbydev.libraries.ui.IndexButton


@Composable
private fun IndexButtonWithText() {
    IndexButton(
        onClick = { /* azione di esempio */ },
        stringResourseId = R.string.ok
    )
}

@Composable
private fun IndexButtonWithIcon() {
    IndexButton(
        onClick = { /* azione di esempio */ },
        stringResourseId = R.string.ok,
        icon = Icons.Filled.Build
    )
}

@Composable
private fun IndexButtonWithDescription() {
    IndexButton(
        onClick = { /* azione di esempio */ },
        stringResourseId = R.string.ok,
        descriptionResourseId = R.string.ok
    )
}

@Composable
private fun IndexButtonWithIconCustomTint() {
    IndexButton(
        onClick = { /* azione di esempio */ },
        stringResourseId = R.string.ok,
        icon = Icons.Filled.Build,
        tint = Color.Red
    )
}