package com.proferoberto.holamundo.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.proferoberto.holamundo.R

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