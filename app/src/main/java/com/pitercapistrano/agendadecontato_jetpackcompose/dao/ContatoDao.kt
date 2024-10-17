package com.pitercapistrano.agendadecontato_jetpackcompose.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.pitercapistrano.agendadecontato_jetpackcompose.model.Contato

@Dao
interface ContatoDao {

    @Insert
    fun salvarContato(listaContato: MutableList<Contato>)

    @Query("SELECT * FROM tabela_contatos ORDER BY nome ASC")
    fun getContatos(): MutableList<Contato>

    @Query("UPDATE tabela_contatos SET nome = :novoNome, sobrenome = :novoSobrenome, email = :novoEmail, telefone = :novoTelefone " +
    "WHERE uid = :id")
    fun atualizar(id: Int, novoNome: String, novoSobrenome: String, novoEmail: String, novoTelefone: String)

    @Query("DELETE FROM tabela_contatos WHERE uid = :id")
    fun deletar(id: Int)
}