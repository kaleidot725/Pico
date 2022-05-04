package view.components.explorer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.FeatherIcons
import compose.icons.feathericons.Home

@Composable
fun Title(
    title: String,
    onOpen: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        Text(
            text = "EXPLORER",
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            fontSize = 14.sp,
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
}