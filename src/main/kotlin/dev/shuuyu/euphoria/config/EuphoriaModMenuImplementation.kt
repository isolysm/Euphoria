package dev.shuuyu.euphoria.config

//#if FABRIC == 1
import com.terraformersmc.modmenu.api.ConfigScreenFactory
import com.terraformersmc.modmenu.api.ModMenuApi

class EuphoriaModMenuImplementation : ModMenuApi {
    override fun getModConfigScreenFactory(): ConfigScreenFactory<*> {
        return ConfigScreenFactory { EuphoriaConfig.gui() }
    }
}
//#endif
