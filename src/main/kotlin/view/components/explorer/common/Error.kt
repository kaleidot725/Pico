package view.components.explorer

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Error(message: String, modifier: Modifier) {
    Text(
        text = "You have not yet opened a folder.",
        modifier = modifier,
        style = MaterialTheme.typography.caption
    )
}