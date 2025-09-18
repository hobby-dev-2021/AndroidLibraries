package com.hobbydev.libraries.ui

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
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Link
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Composable che crea un testo di tipo titolo.
 * @param text Testo del titolo.
 * @sample com.hobbydev.libraries.samples.TitleSimple
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
 * Composable che crea una riga con un esempio di testo con un eventuale titolo.
 * @param text Testo dell'esempio.
 * @param title Titolo dell'esempio.
 * @sample com.hobbydev.libraries.samples.ExampleWithTitle
 * @sample com.hobbydev.libraries.samples.ExampleWithoutTitle
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

/**
 * Composable che crea una Card contenente una regola con un testo complesso.
 * @param text Testo complesso della regola.
 * @sample com.hobbydev.libraries.samples.RuleWithAnnotatedText
 */
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

/**
 * Composable che crea una Card contenente una regola con un testo semplice.
 * @param text Testo semplice della regola.
 * @sample com.hobbydev.libraries.samples.RuleWithText
 */
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

/**
 * Bottone cliccabile con icona, testo e descrizione accessibile.
 * @param onClick Funzione da eseguire al click.
 * @param stringResourseId Testo da mostrare.
 * @param descriptionResourseId Descrizione accessibile da mostrare.
 * @param icon icona da mostrare.
 * @param tint colore dell'icona.
 * @sample com.hobbydev.libraries.samples.IndexButtonWithText
 * @sample com.hobbydev.libraries.samples.IndexButtonWithIcon
 * @sample com.hobbydev.libraries.samples.IndexButtonWithDescription
 * @sample com.hobbydev.libraries.samples.IndexButtonWithIconCustomTint
 */
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

/**
 * Composable che crea una Card contenente un'icona con una lettera dell'alfabeto.
 * @param title Lettera dell'alfabeto dell'icona.
 * @param selected Indica se l'icona è selezionata.
 * @param onLetterClick Funzione da eseguire al click sull'icona.
 * @sample com.hobbydev.libraries.samples.AlphabetLetterSelected
 * @sample com.hobbydev.libraries.samples.AlphabetLetterUnselected
 */
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

/**
 * Composable che crea una Card contenente un'icona bandiera.
 * @param flagResId ID della risorsa dell'icona bandiera.
 * @param onFlagClick Funzione da eseguire al click sull'icona.
 * @sample com.hobbydev.libraries.samples.FlagSample
 */
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
 * @sample com.hobbydev.libraries.samples.CustomSnackbarSample
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
 * @sample com.hobbydev.libraries.samples.CustomGridTableMinimal
 * @sample com.hobbydev.libraries.samples.CustomGridTableWithHeader
 * @sample com.hobbydev.libraries.samples.CustomGridTableFull
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
 * @sample com.hobbydev.libraries.samples.CustomAnnotatedGridTableMinimal
 * @sample com.hobbydev.libraries.samples.CustomAnnotatedGridTableWithHeader
 * @sample com.hobbydev.libraries.samples.CustomAnnotatedGridTableFull
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

/**
 * Composable che crea un campo di input per il testo.
 * @param value Valore del campo di input.
 * @param onValueChange Funzione da eseguire al cambio di valore del campo di input.
 * @param enabled Indica se il campo di input è abilitato o meno.
 * @param label Testo da mostrare come label del campo di input.
 * @param singleLine Indica se il campo di input può essere multilinea o meno.
 * @sample com.hobbydev.libraries.samples.CustomInputFieldSimple
 * @sample com.hobbydev.libraries.samples.CustomInputFieldFull
 */
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

/**
 * Composable che crea un campo di ricerca con icona e testo.
 * @param value Testo da ricercare.
 * @param onValueChange Funzione da eseguire al cambio di valore del campo di input.
 * @param label Testo da mostrare come label del campo di input.
 * @param singleLine Indica se il campo di input può essere multilinea o meno.
 * @sample com.hobbydev.libraries.samples.CustomSearchFieldSimple
 * @sample com.hobbydev.libraries.samples.CustomSearchFieldFull
 */
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

/**
 * Composable che crea una riga con uno switch personalizzato.
 * @param checked Indica se l'opzione è selezionata.
 * @param onCheckedChange Funzione da eseguire al cambio di stato dell'opzione.
 * @param text Testo da mostrare.
 * @sample com.hobbydev.libraries.samples.CustomSwitchRowSimple
 */
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

/**
 * Composable che crea un link cliccabile con icona.
 * @param text Testo del link (viene usato anche come contentDescription per l'icona).
 * @param tag Tag del link.
 * @param icon icona da mostrare.
 * @param onClick Funzione da eseguire al click sul link.
 */
@Composable
fun LinkWithIcon(
    text: String,
    tag: String,
    icon: ImageVector = Icons.Filled.Link,
    onClick: () -> Unit,
){
    Row (
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            imageVector = icon,
            contentDescription = text,
            modifier = Modifier
                .size(32.dp),
            tint = MaterialTheme.colorScheme.secondary
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = buildAnnotatedString {
                // parte cliccabile
                pushLink(
                    LinkAnnotation.Clickable(
                        tag = tag,
                        styles = TextLinkStyles(
                            style = SpanStyle(
                                color = MaterialTheme.colorScheme.secondary,
                            )
                        ),
                        linkInteractionListener = { link ->
                            if (link is LinkAnnotation.Clickable) {
                                onClick() // qui richiamo la callback
                            }
                        }
                    )
                )
                withStyle(SpanStyle(textDecoration = TextDecoration.Underline)){
                    append(text)
                }
                pop()
            },
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .padding(vertical = 8.dp)
        )
    }
}

/**
 * Composable che crea un Box con tre label in verticale.
 * @param mainText Testo della prima label.
 * @param subText1 Testo della seconda label.
 * @param subText2 Testo della terza label.
 * @param width Percentuale di larghezza del Box.
 */
@Composable
fun TripleLabelBox(
    mainText: String,
    subText1: String? = null,
    subText2: String? = null,
    width: Float = 1f
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        modifier = Modifier
            .height(IntrinsicSize.Min)
            .fillMaxWidth(fraction = width)
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
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = mainText,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center
                )
                subText1?.let {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = it,
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.primary,
                        textAlign = TextAlign.Center
                    )
                }
                subText2?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.8f),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

/**
 * Composable che crea un Box con un'icona di freccia verso il basso.
 */
@Composable
fun ArrowDown() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Filled.ArrowDownward,
            contentDescription = "Next step",
            modifier = Modifier.size(32.dp),
            tint = MaterialTheme.colorScheme.primary
        )
    }
}

/**
 * Composable che crea un Box con un'icona di freccia verso destra.
 */
@Composable
fun ArrowRight() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
            contentDescription = "Next step",
            modifier = Modifier.size(32.dp),
            tint = MaterialTheme.colorScheme.primary
        )
    }
}



