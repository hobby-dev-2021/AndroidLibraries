package com.hobbydev.libraries.samples

import androidx.compose.runtime.Composable
import com.hobbydev.libraries.ui.AlphabetLetter
import com.hobbydev.libraries.ui.Flag

@Composable
private fun FlagSample(){
    Flag (
        flagResId = android.R.drawable.star_on,
        onFlagClick = { /* azione di esempio */ }
    )
}