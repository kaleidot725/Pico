package view.components.filetree

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import java.io.File

@Composable
fun FileTree(
    targetDirectory: File,
    openDialog: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        if (targetDirectory.path.isEmpty()) {
            Button(
                onClick = { openDialog.invoke() },
                modifier = Modifier.align(Alignment.Center)
            ) {
                Text("OPEN")
            }
        } else {
            Text(targetDirectory.path, modifier = Modifier.align(Alignment.Center))
        }
    }
}