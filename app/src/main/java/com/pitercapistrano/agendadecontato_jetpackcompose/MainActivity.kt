package com.pitercapistrano.agendadecontato_jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pitercapistrano.agendadecontato_jetpackcompose.ui.theme.AgendaDeContatoJetpackComposeTheme
import com.pitercapistrano.agendadecontato_jetpackcompose.viewModel.ContatoViewModel
import com.pitercapistrano.agendadecontato_jetpackcompose.views.AtualizarContato
import com.pitercapistrano.agendadecontato_jetpackcompose.views.ListaContatos
import com.pitercapistrano.agendadecontato_jetpackcompose.views.SalvarContato
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AgendaDeContatoJetpackComposeTheme {

                val navControler = rememberNavController()
                val viewModel: ContatoViewModel = hiltViewModel()

                NavHost(navController = navControler, startDestination = "listaContatos" ){
                    composable("listaContatos"){
                        ListaContatos(navControler, viewModel)
                    }

                    composable("salvarContato") {
                        SalvarContato(navControler, viewModel)
                    }

                    composable(
                        "atualizarContato/{uid}",
                        arguments = listOf(navArgument("uid"){})
                    ) {
                        AtualizarContato(navControler, viewModel, it.arguments?.getString("uid").toString())
                    }
                }
            }
        }
    }
}
