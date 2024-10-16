package com.pitercapistrano.agendadecontato_jetpackcompose.itemlista

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.pitercapistrano.agendadecontato_jetpackcompose.R
import com.pitercapistrano.agendadecontato_jetpackcompose.model.Contato
import com.pitercapistrano.agendadecontato_jetpackcompose.ui.theme.Black
import com.pitercapistrano.agendadecontato_jetpackcompose.ui.theme.Red
import com.pitercapistrano.agendadecontato_jetpackcompose.ui.theme.Shape
import com.pitercapistrano.agendadecontato_jetpackcompose.ui.theme.White

@Composable
fun ContatoItem(
    navController: NavController,
    position: Int,
    listaContato: MutableList<Contato>,
    context: Context
){

    val nome = listaContato[position].nome
    val sobrenome = listaContato[position].sobrenome
    val email = listaContato[position].email
    val telefone = listaContato[position].telefone

    Card(
        colors = CardDefaults.cardColors(
            containerColor = White,
            contentColor = White,
        ),
        elevation = CardDefaults.cardElevation(8.dp),
        shape = Shape.medium,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 20.dp, 10.dp, 10.dp)
    ) {

        ConstraintLayout(
            modifier = Modifier
                .padding(20.dp)
        ) {
            val (txtNome, txtEmail, txtTelefone, btAtulaizar, btDeletar) = createRefs()

            Text(
                text = "Contato: $nome $sobrenome",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Black,
                modifier = Modifier.constrainAs(txtNome){
                    top.linkTo(parent.top, 10.dp)
                    start.linkTo(parent.start, 10.dp)
                }
            )

            Text(
                text = "Email: $email",
                fontSize = 18.sp,
                color = Black,
                modifier = Modifier.constrainAs(txtEmail){
                    top.linkTo(txtNome.bottom, 10.dp)
                    start.linkTo(parent.start, 10.dp)
                }
            )

            Text(
                text = "Telefone: $telefone",
                fontSize = 18.sp,
                color = Black,
                modifier = Modifier.constrainAs(txtTelefone){
                    top.linkTo(txtEmail.bottom, 10.dp)
                    start.linkTo(parent.start, 10.dp)
                }
            )

            Button(
                onClick = { navController.navigate("atualizarContato") },
                modifier = Modifier.constrainAs(btAtulaizar){
                    top.linkTo(txtEmail.bottom)
                    start.linkTo(txtTelefone.end, margin = 5.dp)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = White,
                    contentColor = Black
                ),
                elevation = ButtonDefaults.buttonElevation(
                    disabledElevation = 0.dp,
                    defaultElevation = 0.dp
                )
                ){

                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_edit),
                    contentDescription = "Icone de atualizar contato"
                )
            }

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.constrainAs(btDeletar){
                    top.linkTo(txtEmail.bottom)
                    start.linkTo(btAtulaizar.end, 0.dp)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = White,
                    contentColor = Red
                ),
                elevation = ButtonDefaults.buttonElevation(
                    disabledElevation = 0.dp,
                    defaultElevation = 0.dp
                )
            ){

                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_delete),
                    contentDescription = "Icone de deletar contato"
                )
            }

            }
        }

    }
