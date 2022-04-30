package view.components.explorer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import compose.icons.FeatherIcons
import compose.icons.feathericons.Home
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
                overflow = TextOverflow.Clip,
                modifier = Modifier
                    .weight(1f, fill = true)
                    .align(Alignment.CenterVertically)
            )

            Icon(
                imageVector = FeatherIcons.Home,
                contentDescription = "",
                modifier = Modifier
                    .size(16.dp)
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
                FileTree(
                    file = targetDirectory,
                    level = 0,
                    modifier = Modifier.verticalScroll(rememberScrollState())
                )
            }
        }
    }
}