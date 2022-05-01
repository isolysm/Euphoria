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
    var enableEuphoriaVersion = true

    @Property(
        type = PropertyType.SWITCH,
        name = "Enable Smooth Chat",
        description = "Enables the smooth chat feature.",
        category = "Chat"
    )
    var enableSmoothChat = false

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
        description = "Enables the copy chat feature." +
            "You can copy a message by pressing CTRL and clicking on the message.",
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
        description = "Displays our custom Discord RPC." +
            "This will overwrite the one provided by Mojang themselves.",
        category = "Extras"
    )
    var enableDiscordRPC = true

    @Property(
        type = PropertyType.SWITCH,
        name = "Enable Autoupdater",
        description = "Enables the autoupdater, which will autoupdate this mod whenever there is a new update." +
            "This feature is experimental! You will encounter many bugs.",
        category = "Updater"
    )
    var enableAutoUpdater = false

    @Property(
        type = PropertyType.SELECTOR,
        name = "AutoUpdater",
        description = "Sets the version that you want the updater to update to.",
        category = "Updater",
        options = ["Pre-Release", "Release", "Release-Candidate"]
    )
    var setAutoUpdater = 0

    @Property(
        type = PropertyType.SWITCH, name = "Update Notification",
        description = "Shows updates for when a new Euphoria update is present.",
        category = "Updater"
    )
    var allowUpdaterNotification = true

    init {
        addDependency("enableEuphoriaVersion", "UpdateVerifier")

        initialize()
    }
}
