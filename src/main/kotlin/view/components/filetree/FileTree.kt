package view.components.filetree

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.io.File

@Composable
fun FileTree(
    targetDirectory: File,
    openDialog: () -> Unit,
    cancelDialog: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        if (targetDirectory.path.isEmpty()) {
            Column(
                modifier = Modifier.align(Alignment.Center).padding(16.dp)
            ) {
                Text(
                    text = "You have not yet opened a folder.",
                    modifier = Modifier.fillMaxWidth()
                )
                Button(
                    onClick = { openDialog.invoke() },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Open")
                }
            }
        } else {
            Column(
                modifier = Modifier.align(Alignment.Center).padding(16.dp)
            ) {
                Text(
                    text = targetDirectory.path,
                    modifier = Modifier.fillMaxWidth()
                )

                Button(
                    onClick = { cancelDialog.invoke() },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Close")
                }
            }
        }
    }
}