package com.proferoberto.holamundo

import android.content.res.Configuration
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
import androidx.compose.ui.platform.LocalConfiguration
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
fun BotonDialog(modifier: Modifier = Modifier) {
    val showDialog = remember { mutableStateOf(false) }

    Button(onClick = { showDialog.value = true }) {
        Text("Pincha Aquí")
    }

    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = { Text("¡Hola!") },
            text = { Text("Este es un diálogo en Jetpack Compose") },
            confirmButton = {
                Box(
                    modifier = modifier,
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

@Composable
fun Logo(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.image),
        contentDescription = "Imagen de ejemplo",
        modifier = modifier,
        contentScale = ContentScale.Crop
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarraSuperior(modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Home, // Ícono de Material Design
                    contentDescription = "Icono Home (casa)",
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text("Mi App Kotlin")
            }
        }
    )
}

@Composable
fun FullScreen() {
    // Detecta si el dispositivo está "vertical" u "horizontal"
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    Scaffold(
        topBar = {
            BarraSuperior()
        }
    ) { innerPadding ->
        if (isLandscape) { // horizontal
            Row(
                modifier = Modifier.fillMaxSize().padding(innerPadding),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Logo(Modifier.height(150.dp))
                BotonDialog()
            }
        } else { // vertical
            Column(
                modifier = Modifier.fillMaxSize().padding(innerPadding),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Logo(Modifier.fillMaxWidth())
                BotonDialog(Modifier.fillMaxWidth())
            }
        }
    }
}

// descomenta las propiedades de alto y ancho para ver el preview en landscape (horizontal)
@Preview(showBackground = true/*, widthDp = 700, heightDp = 400*/)
@Composable
fun RockScreenPreview() {
    FullScreen()
}