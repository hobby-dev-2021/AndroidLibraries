package com.hobbydev.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Composable che crea un titolo.
 * @sample com.hobbydev.ui.samples.TitleSimple
 */
@Composable
fun Title(
    text: String
){
    Text(
        text = text,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.headlineMedium,
        color = MaterialTheme.colorScheme.primary,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(
                start = 8.dp,
                end = 8.dp
            )
            .fillMaxWidth()
    )
}

/**
 * Composable che crea un esempio di testo con un eventuale titolo.
 * @sample com.hobbydev.ui.samples.ExampleMinimal
 * @sample com.hobbydev.ui.samples.ExampleFull
 */
@Composable
fun Example(
    text: AnnotatedString,
    title: String? = null
) {
    // Recupero la shape dal tema (mi serve per il titolo)
    val themeShape = MaterialTheme.shapes.medium
    // Creo una nuova shape che mantiene i top arrotondati e i bottom a 0.dp
    // se il themShape non è di tipo RoundedCornerShape, imposto a 0
    val titleShape = RoundedCornerShape(
        topStart = (themeShape as? RoundedCornerShape)?.topStart ?: CornerSize(0.dp),
        topEnd = (themeShape as? RoundedCornerShape)?.topEnd ?: CornerSize(0.dp),
        bottomStart = CornerSize(0.dp),
        bottomEnd = CornerSize(0.dp)
    )

    Row(
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        modifier = Modifier
            .height(IntrinsicSize.Min)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .clip(MaterialTheme.shapes.medium)
                .padding(2.dp)
                .weight(1f)
                .fillMaxHeight()
                .border(
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.secondaryContainer,
                    shape = MaterialTheme.shapes.medium
                )
        ) {
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Se il titolo è stato passato, lo mostriamo sopra
                title?.let {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(titleShape)
                            .background(color = MaterialTheme.colorScheme.secondaryContainer)
                            .padding(horizontal = 2.dp, vertical = 8.dp)
                    ) {
                        Text(
                            text = it,
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.secondary,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }
                }
                // --- corpo ---
                Text(
                    text = text,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(
                            horizontal = 2.dp,
                            vertical = 8.dp
                        ),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary,
                )
            }
        }
    }
}

@Composable
fun Rule(
    text: AnnotatedString
){
    ElevatedCard (
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        modifier = Modifier
            .padding(vertical = 12.dp)
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
    ) {
        Column (
            modifier = Modifier
                .background(MaterialTheme.colorScheme.tertiaryContainer)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceEvenly
        ){
            Text(
                text = text,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onTertiaryContainer,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
    }
}

@Composable
fun Rule(
    text: String
){
    ElevatedCard (
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        modifier = Modifier
            .padding(vertical = 12.dp)
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
    ) {
        Column (
            modifier = Modifier
                .background(MaterialTheme.colorScheme.tertiaryContainer)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceEvenly
        ){
            Text(
                text = text,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onTertiaryContainer,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
    }
}

@Composable
fun IndexButton(
    onClick: () -> Unit,
    @StringRes stringResourseId: Int,
    icon: ImageVector? = null,
    tint: Color = MaterialTheme.colorScheme.onPrimaryContainer,
    @StringRes descriptionResourseId: Int? = null
){
    FilledTonalButton(
        onClick = { onClick() },
        colors = ButtonDefaults.filledTonalButtonColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.primary
        ),
        contentPadding = PaddingValues(16.dp),
        modifier = Modifier
            .padding(
                vertical = 8.dp,
                horizontal = 8.dp
            )
            .fillMaxWidth()
    ) {
        Row (modifier = Modifier
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = if (icon != null) Arrangement.Start else Arrangement.Center
        ) {
            if (icon != null) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(30.dp),
                    tint = tint,
                )
                Spacer(modifier = Modifier.width(16.dp))
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalAlignment = if (icon != null) Alignment.Start else Alignment.CenterHorizontally,
//                modifier = Modifier
//                    .padding(vertical = dimensionResource(id = R.dimen.dimen_8dp))
            ){
                Text(
                    text = stringResource(id = stringResourseId),
                    fontWeight = if (descriptionResourseId != null) FontWeight.Bold else FontWeight.Normal,
                    textAlign = if (icon != null) TextAlign.Start else TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                if (descriptionResourseId != null){
                    Text(
                        text = stringResource(id = descriptionResourseId),
                        fontStyle = FontStyle.Italic,
                        textAlign = if (icon != null) TextAlign.Start else TextAlign.Center,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }
        }
    }
}

@Composable
fun AlphabetLetter(
    title: String,
    selected: Boolean,
    onLetterClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .size(60.dp)
            .padding(2.dp)
            .selectable(
                selected = selected,
                onClick = {
                    onLetterClick.invoke()
                }
            ),
        border = BorderStroke(
            1.dp,
            if (selected) MaterialTheme.colorScheme.primary.copy(0.5f) else MaterialTheme.colorScheme.primary,
        ),
        colors = CardDefaults.cardColors(
            containerColor = if (selected) MaterialTheme.colorScheme.primaryContainer.copy(.5f) else MaterialTheme.colorScheme.primaryContainer,
            contentColor = if (selected) MaterialTheme.colorScheme.primary.copy(.5f) else MaterialTheme.colorScheme.primary
        ),
        shape = RoundedCornerShape(50.dp),
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
            )
        }
    }
}

@Composable
fun Flag(
    @DrawableRes flagResId: Int,
    onFlagClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .size(60.dp)
            .padding(2.dp)
            .selectable(
                selected = true,
                onClick = {
                    onFlagClick.invoke()
                }
            ),
        border = BorderStroke(
            1.dp,
            MaterialTheme.colorScheme.primary,
        ),
        shape = RoundedCornerShape(50.dp),
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = flagResId),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
        }
    }
}

/**
 * Composable che crea una snackbar con un messaggio specificato.
 * @param data Dati della snackbar.
 */
@Composable
fun CustomSnackbar(data: SnackbarData) {
    Surface (
        shape = RoundedCornerShape(50.dp),
        color = MaterialTheme.colorScheme.secondaryContainer,
        shadowElevation = 4.dp,
        modifier = Modifier.padding(12.dp),
    ){
        Text(
            text = data.visuals.message,
            modifier = Modifier
                .padding(12.dp),
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

/**
 * Composable che crea una tabella con righe e colonne dinamici e con testi semplici.
 * @param modifier Modifier che deve essere applicato al layout.
 * @param header Elenco di righe di intestazione. E' possibile indicare più righe e/o più colonne di intestazione.
 * @param headerAlignment Allineamento delle righe di intestazione
 * @param data Elenco di righe di dati. E' possibile indicare più righe e/o più colonne di dati in formato stringa semplice.
 * @param cellAlignments Lista di allineamenti per le colonne che contengono i dati
 * @param columnsWeights Lista di pesi per le colonne
 * @param clickableRows Indica quali righe devono essere cliccabili
 * @param onRowClick Funzione da eseguire al click su una riga
 * @param cornerShape Raggio delle cornici dei contorni
 * @param isDataBold Indica se il testo della cella deve essere grassetto
 * @sample com.hobbydev.ui.samples.SampleCustomGridTableMinimal()
 * @sample com.hobbydev.ui.samples.SampleCustomGridTableWithHeader()
 * @sample com.hobbydev.ui.samples.SampleCustomGridTableFull()
 * @return Unit
 */
@Composable
fun CustomGridTable(
    modifier: Modifier = Modifier,
    header: List<List<String>> = emptyList(),
    headerAlignment: TextAlign = TextAlign.Center,
    data: List<List<String>>,
    cellAlignments: List<TextAlign> = List(data.firstOrNull()?.size ?: 0) { TextAlign.Center },
    columnsWeights: List<Float> = listOf(1f),
    clickableRows: Set<Int> = emptySet(),
    onRowClick: ((rowIndex: Int) -> Unit)? = null,
    cornerShape: Dp = 16.dp,
    isDataBold: ((rowIndex: Int, colIndex: Int) -> Boolean)? = null
) {
    val convertedData = data.map { row ->
        row.mapIndexed { rowIndex, text ->
            AnnotatedString(text)
        }
    }
    CustomAnnotatedGridTable(
        modifier = modifier,
        header = header,
        headerAlignment = headerAlignment,
        annotatedStringData = convertedData,
        cellAlignments = cellAlignments,
        columnsWeights = columnsWeights,
        clickableRows = clickableRows,
        onRowClick = onRowClick,
        cornerShape = cornerShape,
        isDataBold = isDataBold
    )
}

/**
 * Funzione che crea una griglia con testi complessi (annotated).
 * @param modifier Modifier che deve essere applicato al layout
 * @param header Elenco di righe di intestazione. E' possibile indicare più righe e/o più colonne di intestazione
 * @param headerAlignment Allineamento delle righe di intestazione
 * @param data Elenco di righe di dati. E' possibile indicare più righe e/o più colonne di dati in formato stringa semplice
 * @param cellAlignments Lista di allineamenti per le colonne che contengono i dati
 * @param columnsWeights Lista di pesi per le colonne
 * @param clickableRows Indica quali righe devono essere cliccabili
 * @param onRowClick Funzione da eseguire al click su una riga
 * @param cornerShape Raggio delle cornici dei contorni
 * @param isDataBold Indica se il testo della cella deve essere grassetto
 * @return Unit
 */
@Composable
fun CustomAnnotatedGridTable(
    modifier: Modifier = Modifier,
    header: List<List<String>> = emptyList(),
    headerAlignment: TextAlign = TextAlign.Center,
    annotatedStringData: List<List<AnnotatedString>>,
    cellAlignments: List<TextAlign> = List(annotatedStringData.firstOrNull()?.size ?: 0) { TextAlign.Center },
    columnsWeights: List<Float> = listOf(1f),
    clickableRows: Set<Int> = emptySet(),
    onRowClick: ((rowIndex: Int) -> Unit)? = null,
    cornerShape: Dp = 16.dp,
    isDataBold: ((rowIndex: Int, colIndex: Int) -> Boolean)? = null
) {
    Column(
        modifier = modifier.padding(vertical = 8.dp)
    ) {
        //header
        if (header.isNotEmpty()) {
            header.forEachIndexed { rowIndex, row ->
                val rowSize = row.size
                Row(
                    horizontalArrangement = Arrangement.spacedBy(2.dp),
                    modifier = Modifier
                        .height(IntrinsicSize.Min)
                        .padding(1.dp)
                        .fillMaxWidth()
                ) {
                    row.forEachIndexed { colIndex, title ->
                        val isFirstRow = rowIndex == 0
                        val isFirstCol = colIndex == 0
                        val isLastCol = colIndex == rowSize - 1
                        val shape = RoundedCornerShape(
                            topStart = if (isFirstRow && isFirstCol) cornerShape else 0.dp,
                            topEnd = if (isFirstRow && isLastCol) cornerShape else 0.dp,
                        )
                        Box(
                            modifier = Modifier
                                .clip(shape)
                                .weight(columnsWeights.getOrElse(colIndex) { 1f })
                                .fillMaxHeight()
                                .background(MaterialTheme.colorScheme.onSurfaceVariant)
                            //                        .border(
                            //                            width = dimensionResource(id = R.dimen.dimen_1dp),
                            //                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            //                            shape = shape
                            //                        )
                        ) {
                            Text(
                                text = title,
                                textAlign = headerAlignment,
                                modifier = Modifier
                                    .padding(horizontal = 2.dp)
                                    .align(Alignment.Center),
                                style = MaterialTheme.typography.titleLarge,
                                color = MaterialTheme.colorScheme.surfaceVariant
                            )
                        }
                    }
                }
            }
        }
        //rows data
        annotatedStringData.forEachIndexed { rowIndex, row ->
            //calcolo i pesi delle colonne presenti nella riga (row)
            val currentWeights = if (columnsWeights.size >= row.size) {
                columnsWeights.take(row.size)
            } else {
                List(row.size) { 1f } // pesi uniformi
            }
            //calcola allineamenti per ogni cella della riga (row)
            val currentCellsAlignments = if (cellAlignments.size >= row.size) {
                cellAlignments.take(row.size)
            } else {
                List(row.size) { TextAlign.Center } // allineamento al centro
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(2.dp),
                modifier = Modifier
                    .height(IntrinsicSize.Min)
                    .padding(1.dp)
                    .fillMaxWidth()
                    .let {
                        if (rowIndex in clickableRows && onRowClick != null) {
                            it.clickable { onRowClick(rowIndex) }
//                                .background(MaterialTheme.colorScheme.onSurfaceVariant.copy(0.5f))
                        } else {
                            it
                        }
                    }
            ) {
                //calcola numero di colonne massimo della riga corrente
                val maxRowCols = row.maxOfOrNull { row.size } ?: 0
                row.forEachIndexed { colIndex, cellText ->
                    val isTop = rowIndex == 0
//                    val isBottom = rowIndex == rows - 1
                    val isFirst = colIndex == 0
                    val isLast = colIndex == maxRowCols - 1
                    val isLastRow = rowIndex == annotatedStringData.lastIndex
                    val shape: RoundedCornerShape =
                        if (header.isEmpty()) {
                            RoundedCornerShape(
                                topStart = if (isTop && isFirst) cornerShape else 0.dp,
                                topEnd = if (isTop && isLast) cornerShape else 0.dp,
                                bottomStart = if (isLastRow && isFirst) cornerShape else 0.dp,
                                bottomEnd = if (isLastRow && isLast) cornerShape else 0.dp
                            )
                        } else {
                            RoundedCornerShape(
                                bottomStart = if (isLastRow && isFirst) cornerShape else 0.dp,
                                bottomEnd = if (isLastRow && isLast) cornerShape else 0.dp
                            )
                        }

                    Box(
                        modifier = Modifier
                            .clip(shape)
                            .weight(currentWeights.getOrElse(colIndex) { 1f })
                            .fillMaxHeight()
                            .let {
                                if (rowIndex in clickableRows && onRowClick != null) {
                                    it.background(
                                        MaterialTheme.colorScheme.primaryContainer.copy(
                                            0.8f
                                        )
                                    )
                                } else {
                                    it.background(
                                        MaterialTheme.colorScheme.primaryContainer.copy(
                                            0.5f
                                        )
                                    )
                                }
                            }
//                            .background(MaterialTheme.colorScheme.primaryContainer.copy(0.5f))
                            .border(
                                width = 1.dp,
                                color = MaterialTheme.colorScheme.primaryContainer,
                                shape = shape
                            )
                    ) {
//                        val fontWeight = if (isDataBold?.invoke(rowIndex, colIndex) == true) FontWeight.Bold else FontWeight.Normal
//                        Log.d("debug", "$fontWeight: " )
                        Text(
                            text = cellText,
                            textAlign = currentCellsAlignments[colIndex],
                            modifier = Modifier
                                .padding(horizontal = 2.dp)
                                .align(Alignment.Center)
                                .fillMaxWidth(),
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            fontWeight = if (isDataBold?.invoke(rowIndex, colIndex) == true) FontWeight.Bold else FontWeight.Normal
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CustomInputField (
    value: String,
    onValueChange: (String) -> Unit,
    enabled: Boolean = true,
    @StringRes label: Int,
    singleLine: Boolean = true
) {
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        label = {
            Text(
                text = stringResource(label),
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        },
        colors = OutlinedTextFieldDefaults.colors (
            focusedTextColor = MaterialTheme.colorScheme.onSecondaryContainer,
            unfocusedTextColor = MaterialTheme.colorScheme.onSecondaryContainer,
            focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            focusedBorderColor = MaterialTheme.colorScheme.onSecondaryContainer,
        ),
        textStyle = MaterialTheme.typography.titleLarge,
        modifier = Modifier.fillMaxWidth(),
        enabled = enabled,
        singleLine = singleLine,
        shape = MaterialTheme.shapes.medium
    )
}

@Composable
fun CustomSearchField (
    value: String,
    onValueChange: (String) -> Unit,
    @StringRes label: Int,
    singleLine: Boolean = true
) {
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        label = {
            Text(
                text = stringResource(label),
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        },
        trailingIcon = {
            if (value.isEmpty()) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = MaterialTheme.colorScheme.onSecondaryContainer
                )
            } else {
                IconButton(onClick = { onValueChange("") }) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Clear",
                        tint = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }
            }
        },
        colors = OutlinedTextFieldDefaults.colors (
            focusedTextColor = MaterialTheme.colorScheme.onSecondaryContainer,
            unfocusedTextColor = MaterialTheme.colorScheme.onSecondaryContainer,
            focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            focusedBorderColor = MaterialTheme.colorScheme.onSecondaryContainer,
        ),
        textStyle = MaterialTheme.typography.titleLarge,
        modifier = Modifier.fillMaxWidth(),
        singleLine = singleLine,
        shape = MaterialTheme.shapes.medium
    )
}

@Composable
fun CustomSwitchRow (
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    text: String
){
    Row (
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = text,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.secondary,
        )
        Switch(
            checked = checked,
            onCheckedChange = { onCheckedChange(it) },
            colors = SwitchDefaults.colors(
                checkedThumbColor = MaterialTheme.colorScheme.onSecondaryContainer,
                checkedTrackColor = MaterialTheme.colorScheme.secondaryContainer,
                checkedBorderColor = MaterialTheme.colorScheme.onSecondaryContainer
            )
        )
    }
}





