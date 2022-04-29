package view.components.filetree

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.io.File

@Composable
fun FileTree(
    targetDirectory: File,
    onOpen: () -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        if (targetDirectory.path.isEmpty()) {
            DirectoryChooser(
                onOpen = onOpen,
                modifier = Modifier.align(Alignment.Center).padding(8.dp)
            )
        } else {
            DirectoryStructure(
                directory = targetDirectory,
                onClose = onClose,
                modifier = Modifier.fillMaxSize().padding(8.dp)
            )
        }
    }
}