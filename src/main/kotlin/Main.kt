import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import model.AppData
import view.common.openDirectory
import view.components.filetree.FileTree
import view.components.preview.Preview
import view.components.splitpane.SplitPane
import view.resource.MainTheme
import view.resource.Strings


fun main() = application {
    val appData = AppData()
    val targetDirectory by appData.targetDirectory.collectAsState()

    Window(onCloseRequest = ::exitApplication, title = Strings.APP_NAME) {
        MainTheme(isDarkMode = false) {
            SplitPane(
                leftContent = {
                    FileTree(
                        targetDirectory = targetDirectory,
                        openDialog = { appData.selectTargetDirectory(openDirectory()) },
                        modifier = Modifier.background(MaterialTheme.colors.background).fillMaxSize()
                    )
                },
                rightContent = {
                    Preview(
                        modifier = Modifier.background(MaterialTheme.colors.background).fillMaxSize()
                    )
                }
            )
        }
    }
}