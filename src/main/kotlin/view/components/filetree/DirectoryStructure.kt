package view.components.filetree

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import java.io.File
import java.util.*

@Composable
fun DirectoryStructure(
    directory: File,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        Row {
            Text(
                text = directory.name.uppercase(Locale.getDefault()),
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .weight(1f, fill = true)
                    .align(Alignment.CenterVertically)
            )

            Icon(
                Icons.Filled.Close,
                contentDescription = "close",
                modifier = Modifier
                    .size(22.dp)
                    .align(Alignment.CenterVertically)
                    .clickable { onClose.invoke() }
            )
        }
    }
}