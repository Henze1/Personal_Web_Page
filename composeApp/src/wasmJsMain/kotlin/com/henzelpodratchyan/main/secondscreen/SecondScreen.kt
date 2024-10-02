package com.henzelpodratchyan.main.secondscreen

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
fun SecondScreen(
    component: SecondScreenComponent
) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column {
            Text(
                text = "Second Screen",
                fontWeight = FontWeight.Bold
            )
            Button(onClick = { component.onBackToFirstScreen() }) {
                Text("Navigate to First Screen")
            }
        }
    }
}