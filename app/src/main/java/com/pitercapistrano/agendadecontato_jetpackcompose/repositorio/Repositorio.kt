package com.pitercapistrano.agendadecontato_jetpackcompose.repositorio

import com.pitercapistrano.agendadecontato_jetpackcompose.dao.ContatoDao
import com.pitercapistrano.agendadecontato_jetpackcompose.model.Contato
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class Repositorio @Inject constructor(private val contatoDao: ContatoDao) {

    val getContatos: Flow<MutableList<Contato>> = contatoDao.getContatos()

    suspend fun salvarContato(listaContatos: MutableList<Contato>){
        contatoDao.salvarContato(listaContatos)
    }

    suspend fun atualizar(id: Int, novoNome: String, novoSobrenome: String, novoEmail: String, novoTelefone: String){
        contatoDao.atualizar(id, novoNome, novoSobrenome, novoEmail, novoTelefone)
    }

    suspend fun deletar(id: Int){
        contatoDao.deletar(id)
    }
}