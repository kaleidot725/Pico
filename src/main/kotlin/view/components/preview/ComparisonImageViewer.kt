package view.components.preview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import model.PreviewImage

@Composable
fun ComparisonImageViewer(
    firstPreviewImage: PreviewImage,
    secondPreviewImage: PreviewImage,
    modifier: Modifier = Modifier
) {
    Row(modifier) {
        ImageViewer(firstPreviewImage, modifier = Modifier.weight(weight = 0.5f, fill = true).fillMaxSize())

        Spacer(modifier = Modifier.width(1.dp).fillMaxHeight().background(Color.LightGray))

        ImageViewer(secondPreviewImage, modifier = Modifier.weight(weight = 0.5f, fill = true).fillMaxSize())
    }
}