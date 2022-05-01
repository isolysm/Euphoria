package dev.shuuyu.euphoria

import ModID.EuphoriaModDirectory
import ModID.EuphoriaModID
import ModID.EuphoriaVersion
import dev.shuuyu.euphoria.config.EuphoriaConfig
import gg.essential.universal.UMinecraft
import gg.essential.universal.UScreen
import gg.essential.vigilance.Vigilance
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import java.io.File


class Euphoria : ModInitializer {
    override fun onInitialize() {
        println("Initializing all libraries, please do not stop the processes.")
        Vigilance.initialize()
        EuphoriaConfig.preload()
        ClientTickEvents.START_CLIENT_TICK.register { tick() }
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
        val ModDirectory = File(EuphoriaModDirectory)
        var gui: UScreen? = null
    }
}
