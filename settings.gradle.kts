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
).forEach { version ->
    include(":$version")
    project(":$version").apply {
        projectDir = file("versions/$version")
        buildFileName = "../../build.gradle.kts"
    }
}

fun getJavaVersion() = System.getProperty("java.version")

gradle.settingsEvaluated {
    if ("true" == System.getProperty("org.gradle.ignoreBuildJavaVersionCheck")) {
        return@settingsEvaluated
    }
    if(JavaVersion.current().ordinal + 1 >= 17) {
        throw GradleException("This build requires JDK 17. You're currently using JDK ${getJavaVersion()}. You can ignore this by passing '-Dorg.gradle.ignoreBuildJavaVersionCheck'")
    }
}

