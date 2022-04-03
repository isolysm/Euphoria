pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        mavenCentral()
        google()
        maven("https://jitpack.io")
        maven("https://maven.fabricmc.net")
        maven("https://maven.minecraftforge.net")
        maven("https://repo.sk1er.club/repository/maven-releases/")
        flatDir {
            dirs=setOf(file("../../libs"))
        }
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

rootProject.name = "Euphoria"
rootProject.buildFileName = "root.gradle.kts"

listOf(
    // Legacy versions that we might not even add whatsoever. (These are mainly for forge)
    // "1.8.9",
    // "1.12.2",
    // Fabric Verisons
    "1.18.1-fabric",
    "1.18.2-fabric"
).forEach { version ->
    include(":$version")
    project(":$version").apply {
        projectDir = file("versions/$version")
        buildFileName = "../../build.gradle"
    }
}