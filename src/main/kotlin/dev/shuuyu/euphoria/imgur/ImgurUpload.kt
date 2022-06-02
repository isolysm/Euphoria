package dev.shuuyu.euphoria.imgur

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import java.util.*

/*
Taken and modified from Patcher, originally made by Sk1erLLC
Licensed under the CC-BY-NC-SA-4.0 License.
 */
class ImgurUpload(private val clientId: String) {
    private val ImgurAPIId = ""
    suspend fun upload(file: File) {
        val fileContent = withContext(Dispatchers.IO) { file.readBytes() }
        val data = Base64.getEncoder().encodeToString(fileContent)
        val encodedParams = "image=" + withContext(Dispatchers.IO) { URLEncoder.encode(data, "UTF-8") }

        return withContext(Dispatchers.IO) {
            val request = URL("https://api.imgur.com/3/image").openConnection() as HttpURLConnection
            request.doInput = true
            request.doOutput = true
            request.requestMethod = "POST"
        }
    }
}
