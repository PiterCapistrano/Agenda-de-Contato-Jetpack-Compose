package com.pitercapistrano.agendadecontato_jetpackcompose.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.pitercapistrano.agendadecontato_jetpackcompose.model.Contato
import kotlinx.coroutines.flow.Flow

@Dao
interface ContatoDao {

    @Insert
   suspend fun salvarContato(listaContato: MutableList<Contato>)

    @Query("SELECT * FROM tabela_contatos ORDER BY nome ASC")
    /* Método utilizado antes da refatoração para arquitetura MVVM
    fun getContatos(): MutableList<Contato>*/
    // Método refatorado
    fun getContatos(): Flow<MutableList<Contato>>

    @Query("UPDATE tabela_contatos SET nome = :novoNome, sobrenome = :novoSobrenome, email = :novoEmail, telefone = :novoTelefone " +
    "WHERE uid = :id")
    suspend fun atualizar(id: Int, novoNome: String, novoSobrenome: String, novoEmail: String, novoTelefone: String)

    @Query("DELETE FROM tabela_contatos WHERE uid = :id")
    suspend fun deletar(id: Int)
}