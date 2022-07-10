package dev.shuuyu.euphoria

import ModID.EuphoriaModID
import ModID.EuphoriaVersion
import dev.shuuyu.euphoria.config.EuphoriaConfig
import gg.essential.universal.UMinecraft
import gg.essential.universal.UScreen
import gg.essential.vigilance.Vigilance
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import java.io.File


class Euphoria : ClientModInitializer {

    override fun onInitializeClient() {
        println("Initializing all libraries, please do not stop the processes.")
        Vigilance.initialize()
        EuphoriaConfig.preload()
        ClientTickEvents.START_CLIENT_TICK.register { tick() }

        CoroutineScope(Dispatchers.IO + CoroutineName("Euphoria Updater Checker")).launch {
            try {
                println("TO BE IMPLEMENTED")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun tick() {
        if (gui != null) {
            try {
                UMinecraft.getMinecraft()
            } catch (e: Exception) {
                e.printStackTrace()
            }
            gui = null
        }
    }

    companion object {
        const val MOD_ID = EuphoriaModID
        const val VERSION = EuphoriaVersion
        val ModDirectory = File("./EuphoriaModDirectory")
        var gui: UScreen? = null
    }
}
