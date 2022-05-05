package model

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.loadImageBitmap
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.io.File

class AppData {
    private val _targetDirectory: MutableStateFlow<File> = MutableStateFlow(File(""))
    val targetDirectory: StateFlow<File> = _targetDirectory

    private val _targetFile: MutableStateFlow<File> = MutableStateFlow(File(""))
    val targetFile: StateFlow<File> = _targetFile

    private val _targetFileBitmap: MutableStateFlow<ImageBitmap?> = MutableStateFlow(null)
    val targetFileBitmap: StateFlow<ImageBitmap?> = _targetFileBitmap

    fun selectTargetDirectory(directory: File) {
        _targetDirectory.value = directory
    }

    fun selectTargetFile(file: File) {
        _targetFile.value = file

        try {
            _targetFileBitmap.value = loadImageBitmap(file.inputStream())
        } catch (e: Exception) {
            _targetFileBitmap.value = null
        }
    }

    fun clearTargetFile() {
        _targetFile.value = File("")
        _targetFileBitmap.value = null
    }
}