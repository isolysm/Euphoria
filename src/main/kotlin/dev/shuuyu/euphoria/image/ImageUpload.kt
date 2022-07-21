package dev.shuuyu.euphoria.image

import java.io.File
import java.io.IOException

object ImageUpload {
    private val ascellaKey = ImageAccess("")
    private val imgurKey = ImageAccess("")

    fun upload(file: File?) {
        try {

        } catch (e: Exception) {
            throw IOException("Failed to upload image to your specified image provider. Perhaps you should wait a bit?")
        }
    }
}
