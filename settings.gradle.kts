includeBuild("build-logic")

pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        mavenCentral()
        google()
        maven("https://jitpack.io")
        maven("https://maven.fabricmc.net")
        maven {"https://maven.architectury.dev/" }
        maven {"https://files.minecraftforge.net/maven/" }
    }
    resolutionStrategy {
        eachPlugin{
            when (requested.id.id) {
                "com.replaymod.preprocess" -> {
                    useModule("com.github.replaymod:preprocessor:${requested.version}")
                }
            }
        }
    }
}

rotProject.name = "Euphoria"
rootProject.buildFileName = "root.gradle.kts"

listOf(
    "1.18.2-fabric"
).forEach { version ->
    include(":$version")
    project(":$version").apply {
        projectDir = file("version/$version")
        buildFileName = "../../build.gradle.kts"
    }
}