package view.components.preview

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap

@Composable
fun Preview(bitmap: ImageBitmap?, modifier: Modifier = Modifier) {
    Box(modifier) {
        if (bitmap != null) {
            Image(bitmap = bitmap, contentDescription = "", modifier = Modifier.align(Alignment.Center))
        } else {
            Text(text = "has error", modifier = Modifier.align(Alignment.Center))
        }
    }
}