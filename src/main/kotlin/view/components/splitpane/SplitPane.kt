package view.components.splitpane

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.splitpane.ExperimentalSplitPaneApi
import org.jetbrains.compose.splitpane.HorizontalSplitPane
import org.jetbrains.compose.splitpane.rememberSplitPaneState
import java.awt.Cursor


@OptIn(ExperimentalSplitPaneApi::class)
@Composable
fun SplitPane(leftContent: @Composable () -> Unit, rightContent: @Composable () -> Unit) {
    @OptIn(ExperimentalComposeUiApi::class)
    fun Modifier.cursorForHorizontalResize(): Modifier = pointerHoverIcon(PointerIcon(Cursor(Cursor.E_RESIZE_CURSOR)))

    val splitterState = rememberSplitPaneState()
    HorizontalSplitPane(
        splitPaneState = splitterState
    ) {
        first(200.dp) {
            leftContent()
        }
        second {
            rightContent()
        }
        splitter {
            visiblePart {
                Box(
                    Modifier
                        .width(1.dp)
                        .fillMaxHeight()
                        .background(Color.LightGray)
                )
            }
            handle {
                Box(
                    Modifier
                        .markAsHandle()
                        .width(1.dp)
                        .fillMaxHeight()
                        .background(Color.LightGray)
                        .cursorForHorizontalResize()
                )
            }
        }
    }
}