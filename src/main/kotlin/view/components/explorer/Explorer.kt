package view.components.explorer

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import cafe.adriel.bonsai.core.Bonsai
import cafe.adriel.bonsai.core.BonsaiStyle
import cafe.adriel.bonsai.filesystem.FileSystemTree
import java.io.File

@Composable
fun Explorer(
    targetDirectory: File,
    onOpen: () -> Unit,
    modifier: Modifier = Modifier
) {
    val targetIsEmpty = targetDirectory.path.isEmpty()
    Column(modifier) {
        Row(modifier = Modifier.padding(8.dp)) {
            Text(
                text = "EXPLORER",
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .weight(1f, fill = true)
                    .align(Alignment.CenterVertically)
            )

            Icon(
                Icons.Filled.Home,
                contentDescription = "",
                modifier = Modifier
                    .size(22.dp)
                    .align(Alignment.CenterVertically)
                    .clickable { onOpen.invoke() }
            )
        }

        Box(modifier = modifier.fillMaxSize()) {
            if (targetIsEmpty) {
                Text(
                    text = "You have not yet opened a folder.",
                    modifier = Modifier.wrapContentSize().align(Alignment.Center).padding(bottom = 40.dp),
                    style = MaterialTheme.typography.caption
                )
            } else {
                Crossfade(targetDirectory.path) {
                    Bonsai(
                        tree = FileSystemTree(rootPath = targetDirectory, selfInclude = true),
                        style = BonsaiStyle(toggleIcon = { rememberVectorPainter(Icons.Default.KeyboardArrowRight) }),
                        modifier = Modifier.padding(vertical = 4.dp).fillMaxSize()
                    )
                }
            }
        }
    }
}