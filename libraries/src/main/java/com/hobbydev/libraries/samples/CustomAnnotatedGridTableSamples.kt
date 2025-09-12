package com.hobbydev.libraries.samples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.hobbydev.libraries.ui.CustomAnnotatedGridTable

@Composable
fun CustomAnnotatedGridTableMinimal(){
    val data = listOf(
        listOf(
            buildAnnotatedString {
                append("riga 1 ")
                withStyle(SpanStyle(fontWeight = FontWeight.Bold)){
                    append("colonna 1 in grassetto")
                }
            },
            buildAnnotatedString {
                append("riga 1 ")
                withStyle(SpanStyle(fontStyle = FontStyle.Italic)){
                    append("colonna 2 in corsivo")
                }
            }
        ),
        listOf(
            buildAnnotatedString {
                append("riga 2 ")
                withStyle(SpanStyle(fontWeight = FontWeight.Bold)){
                    append("colonna 1 in grassetto")
                }
            },
            buildAnnotatedString {
                append("riga 2 ")
                withStyle(SpanStyle(fontStyle = FontStyle.Italic)){
                    append("colonna 2 in corsivo")
                }
            }
        ),
        listOf(
            buildAnnotatedString {
                append("riga 3 ")
                withStyle(SpanStyle(fontStyle = FontStyle.Italic)){
                    append("solo una colonna che occupa tutto lo spazio")
                }
            }
        )
    )
    CustomAnnotatedGridTable(
        annotatedStringData = data
    )
}

@Composable
fun CustomAnnotatedGridTableWithHeader(){
    Column {
        val oneHeaderColum = listOf(listOf("l'intestazione occupa 2 colonne"))
        val data1 = listOf(
            listOf(
                buildAnnotatedString {
                append("riga 1 ")
                withStyle(SpanStyle(fontWeight = FontWeight.Bold)){
                    append("colonna 1 in grassetto")
                }
            },
                buildAnnotatedString {
                    append("riga 1 ")
                    withStyle(SpanStyle(fontStyle = FontStyle.Italic)){
                        append("colonna 2 in corsivo")
                    }
                }
            ),
            listOf(
                buildAnnotatedString {
                    append("riga 2 ")
                    withStyle(SpanStyle(fontWeight = FontWeight.Bold)){
                        append("colonna 1 in grassetto")
                    }
                },
                buildAnnotatedString {
                    append("riga 2 ")
                    withStyle(SpanStyle(fontStyle = FontStyle.Italic)){
                        append("colonna 2 in corsivo")
                    }
                }
            )
        )
        CustomAnnotatedGridTable(
            header = oneHeaderColum,
            annotatedStringData = data1
        )

        val header = listOf(listOf("intestazione 1", "intestazione 2"))
        val data2 = listOf(
            listOf(
                buildAnnotatedString {
                    append("riga 1 ")
                    withStyle(SpanStyle(fontWeight = FontWeight.Bold)){
                        append("colonna 1 in grassetto")
                    }
                },
                buildAnnotatedString {
                    append("riga 1 ")
                    withStyle(SpanStyle(fontStyle = FontStyle.Italic)){
                        append("colonna 2 in corsivo")
                    }
                }
            ),
            listOf(
                buildAnnotatedString {
                    append("riga 2 ")
                    withStyle(SpanStyle(fontWeight = FontWeight.Bold)){
                        append("colonna 1 in grassetto")
                    }
                },
                buildAnnotatedString {
                    append("riga 2 ")
                    withStyle(SpanStyle(fontStyle = FontStyle.Italic)){
                        append("colonna 2 in corsivo")
                    }
                }
            )
        )
        CustomAnnotatedGridTable(
            header = header,
            annotatedStringData = data2
        )

        val doubleHeader = listOf(
            listOf("intestazione prima riga"),
            listOf("intestazione riga 2 colonna 1", "intestazione riga 2 colonna 2")
        )
        val data3 = listOf(
            listOf(
                buildAnnotatedString {
                    append("riga 1 ")
                    withStyle(SpanStyle(fontWeight = FontWeight.Bold)){
                        append("colonna 1 in grassetto")
                    }
                },
                buildAnnotatedString {
                    append("riga 1 ")
                    withStyle(SpanStyle(fontStyle = FontStyle.Italic)){
                        append("colonna 2 in corsivo")
                    }
                }
            ),
            listOf(
                buildAnnotatedString {
                    append("riga 2 ")
                    withStyle(SpanStyle(fontWeight = FontWeight.Bold)){
                        append("colonna 1 in grassetto")
                    }
                },
                buildAnnotatedString {
                    append("riga 2 ")
                    withStyle(SpanStyle(fontStyle = FontStyle.Italic)){
                        append("colonna 2 in corsivo")
                    }
                }
            )
        )
        CustomAnnotatedGridTable(
            header = doubleHeader,
            annotatedStringData = data3
        )
    }

}

@Composable
fun CustomAnnotatedGridTableFull(){
    Column {
        val doubleHeader = listOf(
            listOf("intestazione prima riga"),
            listOf("intestazione riga 2 colonna 1", "intestazione riga 2 colonna 2")
        )
        val data3 = listOf(
            listOf(
                buildAnnotatedString {
                    append("riga 1 ")
                    withStyle(SpanStyle(fontWeight = FontWeight.Bold)){
                        append("colonna 1 in grassetto")
                    }
                },
                buildAnnotatedString {
                    append("riga 1 ")
                    withStyle(SpanStyle(fontStyle = FontStyle.Italic)){
                        append("colonna 2 in corsivo")
                    }
                }
            ),
            listOf(
                buildAnnotatedString {
                    append("riga 2 ")
                    withStyle(SpanStyle(fontWeight = FontWeight.Bold)){
                        append("colonna 1 in grassetto")
                    }
                },
                buildAnnotatedString {
                    append("riga 2 ")
                    withStyle(SpanStyle(fontStyle = FontStyle.Italic)){
                        append("colonna 2 in corsivo")
                    }
                }
            )
        )
        CustomAnnotatedGridTable(
            modifier = Modifier.fillMaxWidth(),
            header = doubleHeader,
            headerAlignment = TextAlign.Left,
            annotatedStringData = data3,
            cellAlignments = listOf(
                TextAlign.Start,
                TextAlign.Center,
            ),
            columnsWeights = listOf(0.5f, 1f),
            clickableRows = setOf(0, 2), // solo la prima e terza riga cliccabili
            onRowClick = { /* funzione da eseguire al click sulla riga */ },
            cornerShape = 0.dp,
            isDataBold = { row, col -> row == 0 || col == 1 } //la riga 0 e la colonna 1 in grassetto
            //isDataBold = { row, _ -> row in listOf(0,2,4) } //le righe 0,2,4 in grassetto
            //isDataBold = { _, _ -> true } //tutti i dati in grassetto
            //isDataBold = { row, _ -> row % 2 == 0 } // tutte le righe dispari (0-based)
            //isDataBold = { _, col -> col == 1 } //la colonna 1 in grassetto
        )
    }

}