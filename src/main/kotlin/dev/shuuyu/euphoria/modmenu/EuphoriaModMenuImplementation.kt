package dev.shuuyu.euphoria.modmenu

//#if FABRIC == 1
import com.terraformersmc.modmenu.api.ConfigScreenFactory
import com.terraformersmc.modmenu.api.ModMenuApi
import dev.shuuyu.euphoria.config.EuphoriaConfig

class EuphoriaModMenuImplementation : ModMenuApi {
    override fun getModConfigScreenFactory() =
        ConfigScreenFactory { EuphoriaConfig.gui() }
}
//#endif
