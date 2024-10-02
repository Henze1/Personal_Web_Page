package com.henzelpodratchyan.main.secondscreen

import com.arkivanov.decompose.ComponentContext

interface SecondScreenComponent {
    fun onBackToFirstScreen()
}

class DefaultSecondScreenComponent(
    componentContext: ComponentContext,
    private val onBackToFirstScreenClicked: () -> Unit
): SecondScreenComponent, ComponentContext by componentContext {
    override fun onBackToFirstScreen() {
        onBackToFirstScreenClicked()
    }
}