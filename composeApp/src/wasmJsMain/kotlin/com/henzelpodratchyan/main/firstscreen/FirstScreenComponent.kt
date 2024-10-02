package com.henzelpodratchyan.main.firstscreen

import com.arkivanov.decompose.ComponentContext

interface FirstScreenComponent {
    fun onNavigateToSecondScreen()
}

class DefaultFirstScreenComponent(
    componentContext: ComponentContext,
    private val onShowSecondScreenClicked: () -> Unit
): FirstScreenComponent, ComponentContext by componentContext {
    override fun onNavigateToSecondScreen() {
        onShowSecondScreenClicked()
    }
}