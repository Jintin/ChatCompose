package com.jintin.chatcompose.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun InputLayout(modifier: Modifier = Modifier, updateQuery: (String) -> Unit) {
    Row(modifier = modifier) {
        var text by remember { mutableStateOf("") }
        OutlinedTextField(
            value = text,
            modifier = Modifier
                .weight(1f)
                .align(Alignment.Bottom)
                .padding(8.dp),
            onValueChange = { text = it },
            colors = customTextColors(),
        )
        Button(
            enabled = text.isNotEmpty(),
            onClick = {
                if (text.isNotEmpty()) {
                    updateQuery(text)
                    text = ""
                }
            },
            modifier = Modifier
                .align(Alignment.Bottom)
                .padding(8.dp)
        ) {
            Text(text = "Send")
        }
    }
}


@Composable
private fun customTextColors(): TextFieldColors =
    TextFieldDefaults.outlinedTextFieldColors(
        textColor = MaterialTheme.colorScheme.onBackground,
        disabledTextColor = MaterialTheme.colorScheme.onBackground,
        backgroundColor = MaterialTheme.colorScheme.background,
        cursorColor = MaterialTheme.colorScheme.onBackground,
        errorCursorColor = MaterialTheme.colorScheme.error,
        focusedBorderColor = MaterialTheme.colorScheme.primary,
        unfocusedBorderColor = MaterialTheme.colorScheme.onBackground,
        disabledBorderColor = MaterialTheme.colorScheme.onBackground,
        errorBorderColor = MaterialTheme.colorScheme.error,
        leadingIconColor = MaterialTheme.colorScheme.onBackground,
        disabledLeadingIconColor = MaterialTheme.colorScheme.onBackground,
        errorLeadingIconColor = MaterialTheme.colorScheme.error,
        trailingIconColor = MaterialTheme.colorScheme.onBackground,
        disabledTrailingIconColor = MaterialTheme.colorScheme.onBackground,
        errorTrailingIconColor = MaterialTheme.colorScheme.error,
        focusedLabelColor = MaterialTheme.colorScheme.primary,
        unfocusedLabelColor = MaterialTheme.colorScheme.onBackground,
        disabledLabelColor = MaterialTheme.colorScheme.onBackground,
        errorLabelColor = MaterialTheme.colorScheme.error,
        placeholderColor = MaterialTheme.colorScheme.onBackground,
        disabledPlaceholderColor = MaterialTheme.colorScheme.primary,
    )