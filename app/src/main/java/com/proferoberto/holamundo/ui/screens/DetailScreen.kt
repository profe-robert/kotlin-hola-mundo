package com.proferoberto.holamundo.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.proferoberto.holamundo.NavRoutes
import com.proferoberto.holamundo.ui.components.BarraSuperior
import com.proferoberto.holamundo.ui.components.Logo

@Composable
fun DetailScreen(navController: NavController) {

    Scaffold(
        topBar = {
            BarraSuperior("Detalle de Producto")
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Guitarra Eléctrica Fender Stratocaster")
            Logo(Modifier.height(200.dp))

            Button(onClick = { navController.navigate(NavRoutes.PROFILE) }) {
                Text("Ver Perfil del Comprador")
            }
        }
    }
}