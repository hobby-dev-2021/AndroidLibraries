package com.hobbydev.libraries.samples

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.hobbydev.libraries.ui.CustomSearchField

@Composable
private fun CustomSearchFieldSimple() {
    var searchText by remember { mutableStateOf("") }

    CustomSearchField(
        value = searchText,
        onValueChange = { searchText = it },
        label = android.R.string.search_go
    )
}

@Composable
private fun CustomSearchFieldFull() {
    var searchText by remember { mutableStateOf("") }

    CustomSearchField(
        value = searchText,
        onValueChange = { searchText = it },
        label = android.R.string.search_go,
        singleLine = false
    )
}