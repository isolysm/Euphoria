package dev.shuuyu.euphoria.config

import com.terraformersmc.modmenu.api.ConfigScreenFactory
import com.terraformersmc.modmenu.api.ModMenuApi

class EuphoriaModMenuImplementation : ModMenuApi {
    override fun getModConfigScreenFactory(): ConfigScreenFactory<*> {
        return ConfigScreenFactory { EuphoriaConfig.gui() }
    }
}
