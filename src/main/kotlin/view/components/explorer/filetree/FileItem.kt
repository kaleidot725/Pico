package view.components.explorer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.FeatherIcons
import compose.icons.feathericons.File
import compose.icons.feathericons.Image
import java.io.File

@Composable
fun FileItem(
    file: File,
    onClickMenu: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        Spacer(
            modifier = Modifier
                .size(16.dp)
                .align(Alignment.CenterVertically)
        )

        Icon(
            imageVector = FeatherIcons.File,
            contentDescription = null,
            modifier = Modifier.size(16.dp)
        )

        Text(
            text = file.name,
            maxLines = 1,
            fontSize = 12.sp,
            overflow = TextOverflow.Visible,
            modifier = Modifier
                .weight(1f, fill = true)
                .align(Alignment.CenterVertically)
        )

        Icon(
            imageVector = FeatherIcons.Image,
            contentDescription = null,
            modifier = Modifier
                .size(16.dp)
                .clickable { onClickMenu.invoke() }
        )
    }
}