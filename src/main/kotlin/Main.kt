import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import model.AppData
import model.PreviewImage
import view.common.openDirectory
import view.components.explorer.Explorer
import view.components.preview.SoloImageViewer
import view.components.splitpane.SplitPane
import view.resource.MainTheme
import view.resource.Strings


fun main() = application {
    val appData = AppData()
    val targetDirectory by appData.targetDirectory.collectAsState()
    val firstPreviewImage by appData.firstPreviewImage.collectAsState()
    val secondPreviewImage by appData.secondPreviewImage.collectAsState()

    Window(onCloseRequest = ::exitApplication, title = Strings.APP_NAME) {
        MainTheme(isDarkMode = false) {
            SplitPane(
                leftContent = {
                    Surface {
                        Crossfade(targetDirectory) {
                            Explorer(
                                targetDirectory = targetDirectory,
                                onClickHome = { appData.selectTargetDirectory(openDirectory()) },
                                onClickFile = { file -> appData.selectTargetFile(file, PreviewImage.Position.FIRST) },
                                modifier = Modifier.background(MaterialTheme.colors.background).fillMaxSize()
                            )
                        }
                    }
                },
                rightContent = {
                    Surface {
                        SoloImageViewer(
                            previewImage = firstPreviewImage,
                            modifier = Modifier
                                .background(MaterialTheme.colors.background)
                                .fillMaxSize()
                        )
                    }
                }
            )
        }
    }
}