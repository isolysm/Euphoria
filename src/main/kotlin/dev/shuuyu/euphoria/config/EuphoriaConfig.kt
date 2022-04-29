package dev.shuuyu.euphoria.config

import gg.essential.vigilance.Vigilant
import gg.essential.vigilance.data.Property
import gg.essential.vigilance.data.PropertyType
import java.io.File

object EuphoriaConfig : Vigilant(File("./config/euphoriaConfigurations.toml"), "Euphoria~") {

    @Property(
        type = PropertyType.SWITCH,
        name = "Enable Euphoria",
        description = "Enables Euphoria, and all of the features that Euphoria provides.",
        category = "General"
    )
    var enabledEuphoriaVersion = true

    @Property(
        type = PropertyType.SWITCH,
        name = "Enable Smooth Chat",
        description = "Enables the smooth chat feature inside Euphoria.",
        category = "Chat"
    )
    var enabledSmoothChat = false

    @Property(
        type = PropertyType.SWITCH,
        name = "Enable Chat Compression",
        description = "Compresses all duplicate chat methods.",
        category = "Chat"
    )
    var enableChatCompression = true

    @Property(
        type = PropertyType.SWITCH,
        name = "Enable Copy Chat",
        description = "Enables the copy chat feature. You can copy a message by pressing CTRL and pressing on the message.",
        category = "Chat"
    )
    var enableCopyChat = true

    @Property(
        type = PropertyType.SWITCH,
        name = "Preview Screenshot",
        description = "Displays a picture of the screenshot you've taken.",
        category = "Screenshots"
    )
    var enablePreviewScreenshot = true

    @Property(
        type = PropertyType.SWITCH,
        name = "Discord RPC",
        description = "Displays our custom Discord RPC.",
        category = "Extras"
    )
    var enableDiscordRPC = true

    @Property(
        type = PropertyType.SWITCH,
        name = "Enable Autoupdater",
        description = "Enables the autoupdater, which will autoupdate this mod whenever there is a new update.",
        category = "Extras"
    )
    var enabledAutoUpdater = false

    init {
        initialize()
    }
}
