package dev.shuuyu.euphoria.imgur

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.net.HttpURLConnection
import java.net.URL
import java.util.*

/*
Taken and modified from Patcher, originally made by Sk1erLLC
Licensed under the CC-BY-NC-SA-4.0 License.
 */
object ImgurUpload {
    suspend fun upload(file: File) {
        val base64 = Base64.getEncoder().encodeToString(file.absoluteFile.readBytes())

        return withContext(Dispatchers.IO) {
            val request = URL("https://api.imgur.com/3/image").openConnection() as HttpURLConnection
            request.doInput = true
            request.doOutput = true
        }
    }
}
