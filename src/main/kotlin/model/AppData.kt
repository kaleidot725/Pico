package model

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.io.File

class AppData {
    private val _targetDirectory: MutableStateFlow<File> = MutableStateFlow(File(""))
    val targetDirectory: StateFlow<File> = _targetDirectory

    private val _firstPreviewImage: MutableStateFlow<PreviewImage> = MutableStateFlow(PreviewImage.EMPTY)
    val firstPreviewImage: StateFlow<PreviewImage> = _firstPreviewImage

    private val _secondPreviewImage: MutableStateFlow<PreviewImage> = MutableStateFlow(PreviewImage.EMPTY)
    val secondPreviewImage: StateFlow<PreviewImage> = _secondPreviewImage

    fun selectTargetDirectory(directory: File) {
        _targetDirectory.value = directory
    }

    fun selectTargetFile(file: File, position: PreviewImage.Position) {
        when (position) {
            PreviewImage.Position.FIRST -> {
                _firstPreviewImage.value = PreviewImage(file, position)
            }
            PreviewImage.Position.SECOND -> {
                _secondPreviewImage.value = PreviewImage(file, position)
            }
        }
    }
}