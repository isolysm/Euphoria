package dev.shuuyu.euphoria.updater

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents

object UpdateVerifier {

    fun checkUpdate() {
        ClientTickEvents.START_CLIENT_TICK.register {
            CoroutineScope(Dispatchers.IO + CoroutineName("Euphoria Version Checker")).launch {
                try {

                }   catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }
}

val regex = Regex("^(?<version>[\\d.]+)-?(?<type>\\D+)?(?<typever>\\d+\\.?\\d*)?\$")
