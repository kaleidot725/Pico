package model

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.loadImageBitmap
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.io.File

class AppData {
    private val _targetDirectory: MutableStateFlow<File> = MutableStateFlow(File(""))
    val targetDirectory: StateFlow<File> = _targetDirectory

    private val _firstPreviewFile: MutableStateFlow<File> = MutableStateFlow(File(""))
    val firstPreviewFile: StateFlow<File> = _firstPreviewFile

    private val _firstPreviewBitmap: MutableStateFlow<ImageBitmap?> = MutableStateFlow(null)
    val firstPreviewBitmap: StateFlow<ImageBitmap?> = _firstPreviewBitmap

    private val _secondPreviewFile: MutableStateFlow<File> = MutableStateFlow(File(""))
    val secondPreviewFile: StateFlow<File> = _secondPreviewFile

    private val _secondPreviewBitmap: MutableStateFlow<ImageBitmap?> = MutableStateFlow(null)
    val secondPreviewBitmap: StateFlow<ImageBitmap?> = _secondPreviewBitmap

    fun selectTargetDirectory(directory: File) {
        _targetDirectory.value = directory
    }

    fun selectTargetFile(position: PreviewPosition, file: File) {
        when (position) {
            PreviewPosition.FIRST -> {
                _firstPreviewFile.value = file
                try {
                    _firstPreviewBitmap.value = loadImageBitmap(file.inputStream())
                } catch (e: Exception) {
                    _firstPreviewBitmap.value = null
                }
            }
            PreviewPosition.SECOND -> {
                _secondPreviewFile.value = file
                try {
                    _secondPreviewBitmap.value = loadImageBitmap(file.inputStream())
                } catch (e: Exception) {
                    _secondPreviewBitmap.value = null
                }
            }
        }
    }

    fun clearTargetFile() {
        _firstPreviewFile.value = File("")
        _firstPreviewBitmap.value = null
    }
}