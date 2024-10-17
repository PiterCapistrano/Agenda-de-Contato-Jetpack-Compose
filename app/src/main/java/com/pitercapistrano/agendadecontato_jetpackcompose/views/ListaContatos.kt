package com.pitercapistrano.agendadecontato_jetpackcompose.views

import android.annotation.SuppressLint
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.pitercapistrano.agendadecontato_jetpackcompose.R
import com.pitercapistrano.agendadecontato_jetpackcompose.ui.theme.Purple80
import com.pitercapistrano.agendadecontato_jetpackcompose.ui.theme.White

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaContatos(navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Agenda de Contatos", fontSize = 18.sp, fontWeight = FontWeight.Bold)},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Purple80,
                    titleContentColor = White
                )

            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("salvarContato")
            },
                containerColor = Purple80,
                contentColor = White,
                shape = RoundedCornerShape(50.dp)

            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_add),
                    contentDescription = "Botão de adicionar contato"
                )
            }
        }
    ) {

    }
}

@Preview
@Composable
fun ListaContatosPreview(){
    ListaContatos(navController = rememberNavController())
}
