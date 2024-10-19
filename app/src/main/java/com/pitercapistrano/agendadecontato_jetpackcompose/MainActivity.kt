package com.pitercapistrano.agendadecontato_jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pitercapistrano.agendadecontato_jetpackcompose.ui.theme.AgendaDeContatoJetpackComposeTheme
import com.pitercapistrano.agendadecontato_jetpackcompose.views.AtualizarContato
import com.pitercapistrano.agendadecontato_jetpackcompose.views.ListaContatos
import com.pitercapistrano.agendadecontato_jetpackcompose.views.SalvarContato

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AgendaDeContatoJetpackComposeTheme {

                val navControler = rememberNavController()

                NavHost(navController = navControler, startDestination = "listaContatos" ){
                    composable("listaContatos"){
                        ListaContatos(navControler)
                    }

                    composable("salvarContato") {
                        SalvarContato(navControler)
                    }

                    composable(
                        "atualizarContato/{uid}",
                        arguments = listOf(navArgument("uid"){})
                    ) {
                        AtualizarContato(navControler, it.arguments?.getString("uid").toString())
                    }
                }
            }
        }
    }
}
