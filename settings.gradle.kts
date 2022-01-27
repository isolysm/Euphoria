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

listOf(
    "1.8.9",
    "1.18.1"
).forEach { version ->
    include(":$version:")
    project(":$version:").apply {
        projectDir = file("version/$version")
        buildFileName = "../../build.gradle.kts"
    }
}