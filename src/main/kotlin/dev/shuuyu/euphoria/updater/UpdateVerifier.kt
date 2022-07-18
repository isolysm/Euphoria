package dev.shuuyu.euphoria.updater

import kotlinx.coroutines.*
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import java.net.HttpURLConnection
import java.net.URL

object UpdateVerifier {
    fun checkUpdate(url: URL? = null) {
        ClientTickEvents.START_CLIENT_TICK.register {
            CoroutineScope(Dispatchers.IO + CoroutineName("Euphoria Version Checker")).launch {
                try {
                    val releaseUrl = withContext(Dispatchers.IO) {
                        URL("https://github.com/isolysm/Euphoria/releases").openConnection()
                    } as HttpURLConnection

                }
                catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }
}
