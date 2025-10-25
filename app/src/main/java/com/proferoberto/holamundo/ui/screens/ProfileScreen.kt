package com.proferoberto.holamundo.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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

@Composable
fun ProfileScreen(navController: NavController) {

    Scaffold(
        topBar = {
            BarraSuperior("Perfil")
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Usuario: Juan Pérez")
            Text("⭐⭐⭐⭐☆ 4.5/5")

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = { navController.popBackStack(NavRoutes.HOME, false) }) {
                Text("Volver al Home")
            }
        }
    }
}