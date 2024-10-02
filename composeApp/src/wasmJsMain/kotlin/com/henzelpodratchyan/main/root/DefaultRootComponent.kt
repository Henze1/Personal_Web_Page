package com.henzelpodratchyan.main.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.popTo
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import com.henzelpodratchyan.main.firstscreen.DefaultFirstScreenComponent
import com.henzelpodratchyan.main.firstscreen.FirstScreenComponent
import com.henzelpodratchyan.main.secondscreen.DefaultSecondScreenComponent
import com.henzelpodratchyan.main.secondscreen.SecondScreenComponent

internal class DefaultRootComponent(
    componentContext: ComponentContext
): RootComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()

    override val stack: Value<ChildStack<*, RootComponent.Child>> =
        childStack(
            source = navigation,
            serializer = null,
            initialConfiguration = Config.Screen1,
            handleBackButton = true,
            childFactory = ::child,
        )

    override fun onBackClicked(toIndex: Int) {
        navigation.popTo(index = toIndex)
    }

    private fun child(config: Config, childComponentContext: ComponentContext): RootComponent.Child =
        when (config) {
            is Config.Screen1 -> RootComponent.Child.Screen1(screen1Component(childComponentContext))
            is Config.Screen2 -> RootComponent.Child.Screen2(screen2Component(childComponentContext))
        }

    private fun screen1Component(componentContext: ComponentContext): FirstScreenComponent =
        DefaultFirstScreenComponent(
            componentContext = componentContext,
            onShowSecondScreenClicked = { navigation.push(Config.Screen2) },
        )

    private fun screen2Component(componentContext: ComponentContext): SecondScreenComponent =
        DefaultSecondScreenComponent(
            componentContext = componentContext,
            onBackToFirstScreenClicked = navigation::pop,
        )

    private sealed interface Config {
        data object Screen1 : Config
        data object Screen2 : Config
    }
}