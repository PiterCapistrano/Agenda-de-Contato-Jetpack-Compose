package com.pitercapistrano.agendadecontato_jetpackcompose.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pitercapistrano.agendadecontato_jetpackcompose.model.Contato
import com.pitercapistrano.agendadecontato_jetpackcompose.repositorio.Repositorio
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContatoViewModel @Inject constructor(private val repositorio: Repositorio): ViewModel() {

    private val _todosContatos = MutableStateFlow<MutableList<Contato>>(mutableListOf())
    private val todosContatos: StateFlow<MutableList<Contato>> = _todosContatos

    fun salvarContato(listaContato: MutableList<Contato>){
        viewModelScope.launch {
            repositorio.salvarContato(listaContato)
        }
    }

    fun getContatos(): Flow<MutableList<Contato>>{
        viewModelScope.launch {
            repositorio.getContatos.collect{
                _todosContatos.value = it
            }
        }
        return todosContatos
    }

    fun atualizar(id: Int, novoNome: String, novoSobrenome: String, novoEmail: String, novoTelefone: String){
        viewModelScope.launch {
            repositorio.atualizar(id, novoNome, novoSobrenome, novoEmail, novoTelefone)
        }
    }

    fun deletar(id: Int){
        viewModelScope.launch {
            repositorio.deletar(id)
        }
    }
}