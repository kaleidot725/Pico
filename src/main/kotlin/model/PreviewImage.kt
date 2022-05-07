package model

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.loadImageBitmap
import java.io.File

data class PreviewImage(val file: File, val position: Position) {
    fun loadImageBitmap(): ImageBitmap = loadImageBitmap(file.inputStream())

    enum class Position {
        FIRST,
        SECOND,
        UNKNOWN
    }

    companion object {
        val EMPTY = PreviewImage(File(""), Position.UNKNOWN)
    }
}