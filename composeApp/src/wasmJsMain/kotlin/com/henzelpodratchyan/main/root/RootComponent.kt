package com.henzelpodratchyan.main.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.henzelpodratchyan.main.firstscreen.FirstScreenComponent
import com.henzelpodratchyan.main.secondscreen.SecondScreenComponent

internal interface RootComponent {

    val stack: Value<ChildStack<*, Child>>

    fun onBackClicked(toIndex: Int)

    sealed class Child {
        class Screen1(val component: FirstScreenComponent) : Child()
        class Screen2(val component: SecondScreenComponent) : Child()
    }
}