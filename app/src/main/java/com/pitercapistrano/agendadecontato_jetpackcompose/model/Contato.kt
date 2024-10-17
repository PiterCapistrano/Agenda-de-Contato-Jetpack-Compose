package com.pitercapistrano.agendadecontato_jetpackcompose.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pitercapistrano.agendadecontato_jetpackcompose.constantes.Constantes


@Entity(tableName = Constantes.TABELA_CONTATOS)
data class Contato(
    @ColumnInfo(name = "nome") val nome: String,
    @ColumnInfo(name = "sobrenome") val sobrenome: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "telefone") val telefone: String,
) {

    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
}