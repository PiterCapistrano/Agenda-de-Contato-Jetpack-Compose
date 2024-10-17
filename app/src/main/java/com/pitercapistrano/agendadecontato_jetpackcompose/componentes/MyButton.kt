package com.pitercapistrano.agendadecontato_jetpackcompose.componentes

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pitercapistrano.agendadecontato_jetpackcompose.ui.theme.Purple80
import com.pitercapistrano.agendadecontato_jetpackcompose.ui.theme.White


@Composable
fun MyButton(onClick: () -> Unit, texto: String) {

    Button(
        onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),

        colors = ButtonDefaults.buttonColors(
            containerColor = Purple80,
            contentColor = White
        ),
        shape = RoundedCornerShape(3.dp)

    ){
        Text(text = texto, fontSize = 18.sp, fontWeight = FontWeight.Bold)
    }
}