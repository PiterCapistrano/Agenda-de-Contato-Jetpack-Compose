package com.pitercapistrano.agendadecontato_jetpackcompose.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pitercapistrano.agendadecontato_jetpackcompose.constantes.Constantes
import com.pitercapistrano.agendadecontato_jetpackcompose.dao.ContatoDao
import com.pitercapistrano.agendadecontato_jetpackcompose.model.Contato

@Database(entities = [Contato::class], version = 1)
abstract class DB: RoomDatabase() {

    abstract fun contatoDao(): ContatoDao

    companion object{

        @Volatile
        private var INSTANCE: DB? = null

        fun getInstance(context: Context): DB{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DB::class.java,
                    Constantes.DB_CONTATOS
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}

