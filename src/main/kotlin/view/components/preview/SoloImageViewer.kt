package view.components.preview

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import model.PreviewImage

@Composable
fun SoloImageViewer(
    previewImage: PreviewImage,
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        ImageViewer(previewImage, modifier = Modifier.fillMaxSize())
    }
}