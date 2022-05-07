package view.components.explorer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.PreviewImage
import java.io.File

@Composable
fun Explorer(
    targetDirectory: File,
    onClickHome: () -> Unit,
    onClickMenu: (PreviewImage.Position, File) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        Title(
            title = "EXPLORER",
            onOpen = onClickHome,
            modifier = Modifier.padding(8.dp)
        )

        Box(modifier = modifier.fillMaxSize()) {
            val targetIsEmpty = targetDirectory.path.isEmpty()
            if (targetIsEmpty) {
                Error(
                    message = "You have not yet opened a folder.",
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(bottom = 40.dp)
                        .align(Alignment.Center)
                )
            } else {
                FileTree(
                    file = targetDirectory,
                    level = 0,
                    onClickMenu = { position, file -> onClickMenu.invoke(position, file) },
                    modifier = Modifier.verticalScroll(rememberScrollState())
                )
            }
        }
    }
}