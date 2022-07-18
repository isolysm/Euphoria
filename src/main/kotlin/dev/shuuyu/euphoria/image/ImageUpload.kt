package dev.shuuyu.euphoria.image

import dev.shuuyu.euphoria.config.EuphoriaConfig
import gg.essential.universal.UChat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import java.util.*

/*
Taken and modified from Patcher, originally made by Sk1erLLC
Licensed under the CC-BY-NC-SA-4.0 License.
 */
class ImageUpload(private val clientId: String) {

    suspend fun uploadScreenshot(file: File) {
        val screenshotContent = withContext(Dispatchers.IO) {file.readBytes()}
        val data = Base64.getEncoder().encodeToString(screenshotContent)
        val encodedParams = "image=" + withContext(Dispatchers.IO) { URLEncoder.encode(data, "UTF-8") }

        return withContext(Dispatchers.IO) {
            /*
            Because of Vigilance's weird configuration for dropdown boxes:

           1 -> is Imgur's upload
           2 -> is Ascella's upload

           They should both use the same request methods. If they don't, I'm going to die.
             */
            val request = when (EuphoriaConfig.screenshotUploaderProvider) {
                1 -> URL("https://api.imgur.com/3/image").openConnection() as HttpURLConnection
                2 -> URL("https://ascella.wtf/v2/ascella/upload").openConnection() as HttpURLConnection
                else -> throw IOException("Couldn't determine a proper screenshot upload provider!")
            }
            request.doInput = true
            request.doOutput = true
            request.requestMethod = "POST"
            request.connect()


            if (request.responseCode != 200) {
                UChat.chat("§l§5Euphoria >>> §r§4Image hoster responded with ${request.responseCode}.")
            }
        }
    }
}
