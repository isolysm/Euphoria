pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        mavenCentral()
        google()
        maven {
            name = "sonatype"
            url = uri("https://oss.sonatype.org/content/repositories/snapshots")
        }
        maven{ url = uri("https://jitpack.io") }
        maven{ url = uri("https://maven.minecraftforge.net/") }
        maven{ url = uri("https://maven.fabricmc.net") }
    }
    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "net.minecraftforge.gradle.forge" -> (
                    useModule("com.github.Skytils:ForgeGradle:${requested.version}")
                        )
                "org.spongepowered.mixin" -> (
                    useModule("com.github.Skytils:mixingradle:${requested.version}")
                        )
                "com.replaymod.preprocess" -> (
                    useModule("com.github.replaymod:preprocessor:${requested.version}")
                        )
            }
        }
    }
}

rootProject.buildFileName = "root.gradle.kts"

val euphoriaVersions = listOf(
    //"1.7.10",
    "1.8.9",
    //"1.9.4",
    //"1.10.2",
    //"1.11.2",
    //"1.12.2",
    //"1.15.2",
    //"1.16.5",
    "1.17.1",
    "1.18.1",
)
euphoriaVersions.forEach { version ->
    include(":$version:")
    project(":$version:").apply {
        projectDir = file("version/$version")
        buildFileName = "../../build.gradle.kts"
    }
}