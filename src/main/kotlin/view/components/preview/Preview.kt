package view.components.preview

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import model.PreviewImage

@Composable
fun Preview(
    firstBitmap: PreviewImage,
    secondBimap: PreviewImage,
    modifier: Modifier = Modifier
) {
    Row(modifier) {
        PreviewImage(firstBitmap, modifier = Modifier.weight(weight = 0.5f, fill = true).fillMaxSize())

        Spacer(modifier = Modifier.width(1.dp).fillMaxHeight().background(Color.LightGray))

        PreviewImage(secondBimap, modifier = Modifier.weight(weight = 0.5f, fill = true).fillMaxSize())
    }
}

@Composable
private fun PreviewImage(previewImage: PreviewImage, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        if (previewImage != PreviewImage.EMPTY) {
            Image(
                bitmap = previewImage.loadImageBitmap(),
                contentDescription = "",
                modifier = Modifier.align(Alignment.Center)
            )
        } else {
            Text(text = "has error", modifier = Modifier.align(Alignment.Center))
        }
    }
}