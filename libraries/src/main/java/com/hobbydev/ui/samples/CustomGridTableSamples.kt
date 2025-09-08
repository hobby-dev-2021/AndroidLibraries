package com.hobbydev.ui.samples


import androidx.compose.foundation.layout.Column
import com.hobbydev.ui.CustomGridTable
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun SampleCustomGridTableMinimal(){
    val data = listOf(
        listOf("riga 1 colonna 1", "riga 1 colonna 2"),
        listOf("riga 2 colonna 1", "riga 2 colonna 2"),
        listOf("riga 3 solo una colonna che occupa tutto lo spazio")
    )
    CustomGridTable(
        data = data
    )
}

@Composable
fun SampleCustomGridTableWithHeader(){
    Column {
        val oneHeaderColum = listOf(listOf("l'intestazione occupa 2 colonne"))
        val data1 = listOf(
            listOf("riga 1 colonna 1", "riga 1 colonna 2"),
            listOf("riga 2 colonna 1", "riga 2 colonna 2")
        )
        CustomGridTable(
            header = oneHeaderColum,
            data = data1
        )

        val header = listOf(listOf("intestazione 1", "intestazione 2"))
        val data2 = listOf(
            listOf("riga 1 colonna 1", "riga 1 colonna 2"),
            listOf("riga 2 colonna 1", "riga 2 colonna 2")
        )
        CustomGridTable(
            header = header,
            data = data2
        )

        val doubleHeader = listOf(
            listOf("intestazione prima riga"),
            listOf("intestazione riga 2 colonna 1", "intestazione riga 2 colonna 2")
        )
        val data3 = listOf(
            listOf("riga 1 colonna 1", "riga 1 colonna 2"),
            listOf("riga 2 colonna 1", "riga 2 colonna 2")
        )
        CustomGridTable(
            header = doubleHeader,
            data = data3
        )
    }

}

@Composable
fun SampleCustomGridTableFull(){
    Column {
        val doubleHeader = listOf(
            listOf("intestazione prima riga"),
            listOf("intestazione riga 2 colonna 1", "intestazione riga 2 colonna 2")
        )
        val data3 = listOf(
            listOf("riga 1 colonna 1", "riga 1 colonna 2"),
            listOf("riga 2 colonna 1", "riga 2 colonna 2")
        )
        CustomGridTable(
            header = doubleHeader,
            headerAlignment = TextAlign.Left,
            data = data3,
            columnsWeights = listOf(0.5f, 1f),
            cornerShape = 0.dp,
            isDataBold = { row, col -> row == 0 || col == 1 } //la riga 0 e la colonna 1 in grassetto
            //isDataBold = { row, _ -> row in listOf(0,2,4) } //le righe 0,2,4 in grassetto
            //isDataBold = { _, _ -> true } //tutti i dati in grassetto
            //isDataBold = { row, _ -> row % 2 == 0 } // tutte le righe dispari (0-based)
            //isDataBold = { _, col -> col == 1 } //la colonna 1 in grassetto
        )
    }

}

