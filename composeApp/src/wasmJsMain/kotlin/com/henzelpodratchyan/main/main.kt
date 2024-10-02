package com.henzelpodratchyan.main

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.arkivanov.essenty.lifecycle.resume
import com.henzelpodratchyan.main.root.DefaultRootComponent
import com.henzelpodratchyan.main.root.RootContent
import kotlinx.browser.document

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    val lifecycle = LifecycleRegistry()

    val root = DefaultRootComponent(
        componentContext = DefaultComponentContext(lifecycle = lifecycle),
    )

    lifecycle.resume()

    ComposeViewport(document.body!!) {
        RootContent(component = root)
    }
}