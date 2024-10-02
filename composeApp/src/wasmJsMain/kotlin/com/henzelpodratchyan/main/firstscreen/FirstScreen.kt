package com.henzelpodratchyan.main.firstscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

@Composable
fun FirstScreen(
    component: FirstScreenComponent
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column {
            Text(
                text = "First Screen",
                fontWeight = FontWeight.Bold
            )
            Button(onClick = { component.onNavigateToSecondScreen() }) {
                Text("Navigate to Second Screen")
            }
        }
    }
}