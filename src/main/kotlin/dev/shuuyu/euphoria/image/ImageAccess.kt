package dev.shuuyu.euphoria.image

import dev.shuuyu.euphoria.config.EuphoriaConfig
import gg.essential.universal.UChat
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
class ImageAccess(private val clientId: String) {

    suspend fun uploadScreenshot(file: File) {
        val screenshotContent = withContext(Dispatchers.IO) {file.readBytes()}
        val data = Base64.getEncoder().encodeToString(screenshotContent)
        val encodedParams = "image=" + withContext(Dispatchers.IO) { URLEncoder.encode(data, "UTF-8") }

        return withContext(Dispatchers.IO) {
            /*
            Because of Vigilance's weird configuration for dropdown boxes:

           2 -> is Ascella's upload
           Literally everything else -> is Imgur's upload

           They should both use the same request methods. If they don't, I'm going to die.

           By default, Imgur should be used. However, if the default is secretly zero, this makes everything obsolete and I need to change it.
             */
            val request = when (EuphoriaConfig.screenshotUploaderProvider) {
                2 -> URL("https://ascella.wtf/v2/ascella/upload").openConnection() as HttpURLConnection
                else -> URL("https://api.imgur.com/3/image").openConnection() as HttpURLConnection
            }
            request.doInput = true
            request.doOutput = true
            request.requestMethod = "POST"
            request.setRequestProperty("Authorization", "Client-ID $clientId")
            request.setRequestProperty("Content-Type", "application/x-www-form-urlencode")
            request.connect()


            if (request.responseCode != 200) {
                UChat.chat("§l§5Euphoria >>> §r§4Image hoster responded with ${request.responseCode}.")
            }
        }
    }
}
