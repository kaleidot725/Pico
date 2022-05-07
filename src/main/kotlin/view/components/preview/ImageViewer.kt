package view.components.preview

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import model.PreviewImage

@Composable
fun ImageViewer(previewImage: PreviewImage, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        if (previewImage != PreviewImage.EMPTY) {
            previewImage.loadImageBitmap().fold(
                onSuccess = {
                    Image(
                        bitmap = it,
                        contentDescription = "",
                        modifier = Modifier.align(Alignment.Center)
                    )
                },
                onFailure = {
                    Text(text = "ENCODE ERROR", modifier = Modifier.align(Alignment.Center))
                }
            )
        } else {
            Text(text = "NOT SELECTED", modifier = Modifier.align(Alignment.Center))
        }
    }
}