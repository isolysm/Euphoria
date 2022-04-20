pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        mavenCentral()
        google()
        maven("https://jitpack.io")
        maven("https://maven.terraformersmc.com/releases/")
        maven("https://maven.architectury.dev")
        maven("https://maven.fabricmc.net")
        maven("https://maven.minecraftforge.net")
        maven("https://repo.essential.gg/repository/maven-public")
        flatDir {
            dirs = setOf(file("../../libs"))
        }
    }

    plugins {
        val egtVersion = "0.1.3"
        id("gg.essential.multi-version.root") version egtVersion
        id("gg.essential.multi-version.api-validation") version egtVersion
    }
    /*
    resolutionStrategy {
        eachPlugin{
            when (requested.id.id) {
                "com.replaymod.preprocess" -> {
                    useModule("com.github.replaymod:preprocessor:${requested.version}")
                }
            }
        }
    }

     */
}

rootProject.name = "Euphoria"
rootProject.buildFileName = "root.gradle.kts"

listOf(
    // "1.8.9-forge",
    // "1.12.2-forge",
    "1.18.1-fabric",
    "1.18.2-fabric",
).forEach { version ->
    include(":$version")
    project(":$version").apply {
        projectDir = file("versions/$version")
        buildFileName = "../../build.gradle.kts"
    }
}

