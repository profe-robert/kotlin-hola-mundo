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
import com.proferoberto.holamundo.ui.screens.DetailScreen
import com.proferoberto.holamundo.ui.screens.HomeScreen
import com.proferoberto.holamundo.ui.screens.ProfileScreen

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

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    val navController = rememberNavController()

    HomeScreen(navController)
    // DetailScreen(navController)
    // ProfileScreen(navController)
}