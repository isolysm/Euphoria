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
        type = PropertyType.SWITCH, name = "Infinite Chat",
        description = "Sets the chat length to be infinite.",
        category = "Chat"
    )
    var enableInfChat = true

    @Property(
        type = PropertyType.SWITCH, name = "Chat History",
        description = "Doesn't clear chat history from other servers.",
        category = "Chat"
    )
    var enableChatHistory = true

    @Property(
        type = PropertyType.SWITCH,
        name = "Smooth Chat",
        description = "Enables the smooth chat feature.",
        category = "Chat"
    )
    var enableSmoothChat = false

    @Property(
        type = PropertyType.SWITCH,
        name = "Chat Compression",
        description = "Compresses all duplicate chat methods.",
        category = "Chat"
    )
    var enableChatCompression = true

    @Property(
        type = PropertyType.SWITCH,
        name = "Copy Chat",
        description = "Enables the copy chat feature." +
            "You can copy a message by pressing CTRL and clicking on the message.",
        category = "Chat"
    )
    var enableCopyChat = true

    @Property(
        type = PropertyType.SWITCH, name = "Timestamps",
        description = "Hovering over a message will give you the time it was sent at.",
        category = "Chat"
    )
    var enableHoveringTimestamp = true

    @Property(
        type = PropertyType.SWITCH, name = "Screenshot Upscaling",
        description = "Upscales the resolution of the screenshot." +
            "This is an Experimental feature! You will experience bugs.",
        category = "Screenshots",
    )
    var ScreenshotUpscaler = false

    @Property(
        type = PropertyType.SELECTOR, name = "Screenshot Resolutuion",
        description = "Sets the resolution of the screenshot to the specified value." +
        "Larger resolutions will make it so your screenshots take longer to process!",
        category = "Screenshot",
        options = ["1280x720","1920x1080", "2560x1440", "2880x1620", "3840x2160"]
    )
    var ScreenshotResolution = 0

    @Property(
        type = PropertyType.SWITCH, name = "Preview Screenshot",
        description = "Displays a picture of the screenshot you've taken.",
        category = "Screenshots"
    )
    var enablePreviewScreenshot = true

    @Property(
        type = PropertyType.SELECTOR, name = "Preview Screenshot Position",
        description = "Sets where the animation for the screenshot will take place" +
            "Yes, the wording is a bit off, let me know how to fix it.",
        category = "Screenshot",
        options = ["Bottom-Right", "Bottom-Left", "Top-Right", "Top-Left"]
    )
    var screenShotPosition = 1

    @Property (
        type = PropertyType.SWITCH, name = "Upload Screenshot",
        description = "Uploads the screenshot to the platform of your choosing.",
        category = "Screenshots"
    )
    var uploadScreenshot = true

    @Property (
        type = PropertyType.SELECTOR, name = "Screenshot Upload Provider",
        description = "Sets your preferred platform of uploading (Either Imgur or Asella).",
        category = "Screenshots",
        options = ["Imgur", "Ascella"]
    )
    var screenshotUploaderProvider = 1

    init {
        initialize()
    }
}
