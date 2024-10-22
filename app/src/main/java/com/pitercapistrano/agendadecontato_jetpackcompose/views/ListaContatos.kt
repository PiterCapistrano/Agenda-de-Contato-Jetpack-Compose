package com.pitercapistrano.agendadecontato_jetpackcompose.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
/* Método utilizado antes da refatoração para arquitetura MVVM
import androidx.compose.runtime.rememberCoroutineScope*/
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.pitercapistrano.agendadecontato_jetpackcompose.R
/* Método utilizado antes da refatoração para arquitetura MVVM
import com.pitercapistrano.agendadecontato_jetpackcompose.dao.ContatoDao
import com.pitercapistrano.agendadecontato_jetpackcompose.db.DB*/
import com.pitercapistrano.agendadecontato_jetpackcompose.itemlista.ContatoItem
/* Método utilizado antes da refatoração para arquitetura MVVM
import com.pitercapistrano.agendadecontato_jetpackcompose.model.Contato*/
import com.pitercapistrano.agendadecontato_jetpackcompose.ui.theme.Purple80
import com.pitercapistrano.agendadecontato_jetpackcompose.ui.theme.White
import com.pitercapistrano.agendadecontato_jetpackcompose.viewModel.ContatoViewModel
/* Método utilizado antes da refatoração para arquitetura MVVM
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch*/

/* Método utilizado antes da refatoração para arquitetura MVVM
private lateinit var contatoDao: ContatoDao*/

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaContatos(navController: NavController, viewModel: ContatoViewModel = hiltViewModel()) {

    /* Método utilizado antes da refatoração para arquitetura MVVM
    val listaContato: MutableList<Contato> = mutableListOf()
    val scope = rememberCoroutineScope()*/
    val context = LocalContext.current

    // Método refatorado
    val listaContato = viewModel.getContatos().collectAsState(mutableListOf()).value

    /* Método utilizado antes da refatoração para arquitetura MVVM
    scope.launch(Dispatchers.IO){
        contatoDao = DB.getInstance(context).contatoDao()
        val contatos = contatoDao.getContatos()

        for (contato in contatos){
            listaContato.add(contato)
        }
    }*/

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

        LazyColumn(
            modifier = Modifier.padding(it)
        ) {
            itemsIndexed(listaContato){position, _ ->
                ContatoItem(navController, position, listaContato, context, viewModel)

            }
        }

    }
}

@Preview
@Composable
fun ListaContatosPreview(){
    ListaContatos(navController = rememberNavController())
}
