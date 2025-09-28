package com.hobbydev.libraries.samples

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.hobbydev.libraries.ui.CustomSwitchRow

@Composable
private fun CustomSwitchRowSimple() {
    var isChecked by remember { mutableStateOf(false) }

    CustomSwitchRow(
        checked = isChecked,
        onCheckedChange = { isChecked = it },
        text = "Attiva opzione"
    )
}