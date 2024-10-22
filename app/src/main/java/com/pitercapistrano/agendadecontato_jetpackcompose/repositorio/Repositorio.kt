package com.pitercapistrano.agendadecontato_jetpackcompose.repositorio

import com.pitercapistrano.agendadecontato_jetpackcompose.dao.ContatoDao
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class Repositorio @Inject constructor(private val contatoDao: ContatoDao) {

}