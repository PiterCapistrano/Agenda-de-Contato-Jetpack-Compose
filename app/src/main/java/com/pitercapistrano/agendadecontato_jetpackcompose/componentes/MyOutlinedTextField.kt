package com.pitercapistrano.agendadecontato_jetpackcompose.componentes

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pitercapistrano.agendadecontato_jetpackcompose.ui.theme.Purple40
import com.pitercapistrano.agendadecontato_jetpackcompose.ui.theme.Purple80

@Composable
fun MyOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: @Composable () -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    modifier: Modifier,
    keyboardActions: KeyboardActions
) {

    OutlinedTextField(
        value,
        onValueChange,
    label = label,
    keyboardOptions = keyboardOptions,
    colors = OutlinedTextFieldDefaults.colors(
        cursorColor = Purple80,
        focusedBorderColor = Purple80,
        focusedLabelColor = Purple40
    ),
    keyboardActions = keyboardActions,
    modifier = modifier,
    maxLines = 1,
    singleLine = true
    )
}