package model

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.io.File

class AppData {
    private val _targetDirectory: MutableStateFlow<File> = MutableStateFlow(File(""))
    val targetDirectory: StateFlow<File> = _targetDirectory

    fun selectTargetDirectory(directory: File) {
        // force clear
        _targetDirectory.value = File("")
        _targetDirectory.value = directory
    }
}