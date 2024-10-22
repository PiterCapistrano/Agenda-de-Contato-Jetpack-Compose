package com.pitercapistrano.agendadecontato_jetpackcompose.viewModel

import androidx.lifecycle.ViewModel
import com.pitercapistrano.agendadecontato_jetpackcompose.repositorio.Repositorio
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ContatoViewModel @Inject constructor(private val repositorio: Repositorio): ViewModel() {
}