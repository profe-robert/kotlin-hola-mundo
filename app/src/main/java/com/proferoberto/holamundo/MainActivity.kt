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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.proferoberto.holamundo.ui.theme.HolaMundoTheme
import com.proferoberto.holamundo.R

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HolaMundoTheme {

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = NavRoutes.HOME
                ) {

                    composable(NavRoutes.HOME) {
                        HomeScreen(navController)
                    }

                    composable(NavRoutes.DETAIL) {
                        DetailScreen(navController)
                    }

                    composable(NavRoutes.PROFILE) {
                        ProfileScreen(navController)
                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreen(navController: NavController) {

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

                Button(onClick = { navController.navigate(NavRoutes.DETAIL) }) {
                    Text("Ver Detalle")
                }
            }
        }
    }
}

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

@Composable
fun Logo(modifier: Modifier = Modifier) {
    // compnente Logo
    Image(
        painter = painterResource(id = R.drawable.image),
        contentDescription = "Imagen de ejemplo",
        modifier = modifier,
        contentScale = ContentScale.Crop
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarraSuperior(text: String, modifier: Modifier = Modifier) {
    // componente barra superior
    TopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Home, // Ícono de Material Design
                    contentDescription = "Icono Home (casa)",
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(text)
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    val navController = rememberNavController()

    // HomeScreen(navController)
    // DetailScreen(navController)
    ProfileScreen(navController)
}