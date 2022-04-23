// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import components.filetree.FileTree
import components.preview.Preview
import components.splitpane.SplitPane
import resource.MainTheme
import resource.Strings

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = Strings.APP_NAME) {
        MainTheme(isDarkMode = false) {
            SplitPane(
                leftContent = {
                    FileTree(
                        modifier = Modifier.background(Color.LightGray).fillMaxSize()
                    )
                },
                rightContent = {
                    Preview(
                        modifier = Modifier.background(Color.White).fillMaxSize()
                    )
                }
            )
        }
    }
}