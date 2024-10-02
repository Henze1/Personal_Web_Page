package com.henzelpodratchyan.main.root

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.henzelpodratchyan.main.firstscreen.FirstScreen
import com.henzelpodratchyan.main.secondscreen.SecondScreen

@Composable
internal fun RootContent(
    component: RootComponent
) {
    MaterialTheme {
        Children(
            stack = component.stack,
            modifier = Modifier.fillMaxSize(),
            animation = stackAnimation(fade() + scale())
        ) {
            when (val instance = it.instance) {
                is RootComponent.Child.Screen1 -> FirstScreen(component = instance.component)
                is RootComponent.Child.Screen2 -> SecondScreen(component = instance.component)
            }
        }
    }
}