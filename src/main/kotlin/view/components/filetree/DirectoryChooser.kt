package view.components.filetree

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DirectoryChooser(
    onOpen: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        TextButton(
            onClick = { onOpen.invoke() },
            modifier = Modifier.wrapContentSize()
        ) {
            Text("Open Folder")
        }
    }
}