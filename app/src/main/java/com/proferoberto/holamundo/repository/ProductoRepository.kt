package com.proferoberto.holamundo.repository

import com.proferoberto.holamundo.R
import com.proferoberto.holamundo.model.Producto

class ProductoRepository {
    fun getProductos() = listOf(
        Producto(1, "Fender Stratocaster", 350000, R.drawable.image),
        Producto(2, "Amplificador Marshall", 420000, R.drawable.image)
    )
}