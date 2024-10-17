package com.pitercapistrano.agendadecontato_jetpackcompose.views

import android.widget.Toast
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.pitercapistrano.agendadecontato_jetpackcompose.componentes.MyButton
import com.pitercapistrano.agendadecontato_jetpackcompose.componentes.MyOutlinedTextField
import com.pitercapistrano.agendadecontato_jetpackcompose.model.Contato
import com.pitercapistrano.agendadecontato_jetpackcompose.ui.theme.Purple80
import com.pitercapistrano.agendadecontato_jetpackcompose.ui.theme.Red
import com.pitercapistrano.agendadecontato_jetpackcompose.ui.theme.White
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AtualizarContato(navController: NavController){

    // Inicialize o FocusRequester para cada campo
    val nomeFocusRequester = remember { FocusRequester() }
    val sobrenomeFocusRequester = remember { FocusRequester() }
    val emailFocusRequester = remember { FocusRequester() }
    val telefoneFocusRequester = remember { FocusRequester() }

    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    val listaContatos: MutableList<Contato> = mutableListOf()


    var nome by remember {
        mutableStateOf("")
    }

    var sobrenome by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }
    var telefone by remember {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Atualizar Contato",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Purple80,
                    titleContentColor = White
                )
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            MyOutlinedTextField(
                value = nome,
                onValueChange = { nome = it },
                label = { Text(text = "Nome") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { sobrenomeFocusRequester.requestFocus() }
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 80.dp, 20.dp, 10.dp)
                    .focusRequester(nomeFocusRequester)
                    .focusable()
            )

            MyOutlinedTextField(
                value = sobrenome,
                onValueChange = { sobrenome = it },
                label = { Text(text = "Sobrenome") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { emailFocusRequester.requestFocus() }
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 0.dp, 20.dp, 10.dp)
                    .focusRequester(sobrenomeFocusRequester)
                    .focusable()
            )

            MyOutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                },
                label = { Text(text = "E-mail") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { telefoneFocusRequester.requestFocus() }
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 0.dp, 20.dp, 10.dp)
                    .focusRequester(emailFocusRequester)
                    .focusable()
            )

            MyOutlinedTextField(
                value = telefone,
                onValueChange = { telefone = it },
                label = { Text(text = "Telefone") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { nomeFocusRequester.requestFocus() }
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 0.dp, 20.dp, 10.dp)
                    .focusRequester(telefoneFocusRequester)
                    .focusable()
            )

            MyButton(
                onClick = {
                    if (nome.isEmpty() || sobrenome.isEmpty() || email.isEmpty() || telefone.isEmpty()) {
                        // Mostra a Snackbar
                        coroutineScope.launch {
                            snackbarHostState.showSnackbar(
                                message = "Preencha todos os campos!",
                                duration = SnackbarDuration.Short
                            )
                        }
                    } else {
                        Toast.makeText(context, "Contato Atualizado com Sucesso!", Toast.LENGTH_SHORT).show()
                    }
                },
                texto = "Atualizar"
            )
            // Host para exibir a Snackbar
            SnackbarHost(
                hostState = snackbarHostState,
                modifier = Modifier.fillMaxWidth()
            ) { snackbarData ->
                Snackbar(
                    snackbarData = snackbarData,
                    containerColor = Red,
                    contentColor = White,
                )
            }
        }
    }
}


@Composable
fun AtualizarContatoPreview(){
    AtualizarContato(navController = rememberNavController())
}