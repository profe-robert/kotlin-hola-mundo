package com.proferoberto.holamundo.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.proferoberto.holamundo.repository.ProductoRepository
import androidx.compose.runtime.State
import com.proferoberto.holamundo.model.Producto
/*
    Gestiona estado + lógica de UI.
    Usa MutableState, StateFlow, o LiveData.
    Nada de UI ni contexto aquí.
*/

class HomeViewModel : ViewModel() {

    private val repository = ProductoRepository()

    private val _productos = mutableStateOf(emptyList<Producto>())
    val productos: State<List<Producto>> = _productos

    init {
        _productos.value = repository.getProductos()
    }
}
