package com.pitercapistrano.agendadecontato_jetpackcompose.componentes

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
    keyboardOptions: KeyboardOptions,
    modifier: Modifier
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
    modifier = modifier,
    maxLines = 1
    )
}