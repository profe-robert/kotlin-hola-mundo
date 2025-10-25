package com.proferoberto.holamundo.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.proferoberto.holamundo.NavRoutes
import com.proferoberto.holamundo.ui.components.BarraSuperior
import com.proferoberto.holamundo.ui.components.Logo
import com.proferoberto.holamundo.viewmodel.HomeViewModel

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = viewModel()) {

    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    Scaffold(
        topBar = {
            BarraSuperior("Marketplace")
        }
    ) { innerPadding ->

        if (isLandscape) {
            Row(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Logo(Modifier.height(150.dp))
                Button(onClick = { navController.navigate(NavRoutes.DETAIL) }) {
                    Text("Ver Detalle")
                }
            }
        } else {
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Logo(Modifier.height(180.dp))

                val lista = viewModel.productos.value

                Column {
                    lista.forEach {
                        Text("Producto: ${it.nombre} - ${it.precio}")
                    }
                }

                Button(onClick = { navController.navigate(NavRoutes.DETAIL) }) {
                    Text("Ver Detalle")
                }
            }
        }
    }
}