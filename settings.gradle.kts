pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
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
}

rootProject.name = "Euphoria"
rootProject.buildFileName = "root.gradle.kts"

listOf(
    "1.18.1-fabric",
    "1.18.2-fabric",
    "1.19-fabric"
).forEach { version ->
    include(":$version")
    project(":$version").apply {
        projectDir = file("versions/$version")
        buildFileName = "../../build.gradle.kts"
    }
}
