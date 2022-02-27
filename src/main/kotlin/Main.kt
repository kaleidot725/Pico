// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "ImageDiff") {
        MainTheme(isDarkMode = false) {
            Surface(modifier = Modifier.fillMaxSize()) {
                var text by remember { mutableStateOf("Hello, World!") }

                Button(onClick = {
                    text = "Hello, Desktop!"
                }, modifier = Modifier.wrapContentHeight()) {
                    Text(text)
                }
            }
        }
    }
}
