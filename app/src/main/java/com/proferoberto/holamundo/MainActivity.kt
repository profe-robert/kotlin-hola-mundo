package com.proferoberto.holamundo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.proferoberto.holamundo.ui.theme.HolaMundoTheme
import com.proferoberto.holamundo.R

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HolaMundoTheme {
                FullScreen()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Saludos $name!",
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FullScreen() {
    val showDialog = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Home, // Ícono de Material Design
                            contentDescription = "Icono estrella",
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        Text("Mi App Kotlin")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween, // Esto deja espacio entre la imagen y el botón
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.image),
                contentDescription = "Imagen de ejemplo",
                modifier = Modifier
                    .fillMaxWidth(),
                    // .height(180.dp),
                contentScale = ContentScale.Crop
            )

            Button(onClick = { showDialog.value = true }) {
                Text("Mostrar mensaje")
            }
        }
    }

    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = { Text("¡Hola!") },
            text = { Text("Este es un diálogo en Jetpack Compose") },
            confirmButton = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Button(onClick = { showDialog.value = false }) {
                        Text("Cerrar")
                    }
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RockScreenPreview() {
    FullScreen()
}