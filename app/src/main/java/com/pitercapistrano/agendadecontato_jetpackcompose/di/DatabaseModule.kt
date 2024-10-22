package com.pitercapistrano.agendadecontato_jetpackcompose.di

import android.content.Context
import androidx.room.Room
import com.pitercapistrano.agendadecontato_jetpackcompose.constantes.Constantes
import com.pitercapistrano.agendadecontato_jetpackcompose.db.DB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        DB::class.java,
        Constantes.DB_CONTATOS
        ).build()

    @Singleton
    @Provides
    fun provairdeDao(db: DB) = db.contatoDao()
}