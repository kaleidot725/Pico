package view.common

import java.io.File
import javax.swing.JFileChooser

fun openDirectory(): File {
    val fileChooser = JFileChooser()
    fileChooser.fileSelectionMode = JFileChooser.DIRECTORIES_ONLY
    fileChooser.showOpenDialog(null)
    return try {
        fileChooser.selectedFile
    } catch (e: NullPointerException) {
        File("")
    }
}