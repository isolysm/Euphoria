pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        mavenCentral()
        google()
        maven("https://jitpack.io")
        maven("https://maven.fabricmc.net")
        maven {
            name = "sonatype"
            url = uri("https://oss.sonatype.org/content/repositories/snapshots")
        }
        flatDir {
            dirs=setOf(file("../../libs"))
        }
    }
    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "com.replaymod.preprocess" -> (
                        useModule("com.github.replaymod:preprocessor:${requested.version}")
                        )
                "net.minecraftforge.gradle.forge" -> (
                    useModule("com.github.Skytils:ForgeGradle:${requested.version}")
                        )
                "org.spongepowered.mixin" -> (
                    useModule("com.github.Skytils:mixingradle:${requested.version}")
                        )
            }
        }
    }
}

rootProject.buildFileName = "root.gradle.kts"

listOf(
    "1.8.9"
).forEach { version ->
    include(":$version")
    project(":$version").apply {
        projectDir = file("versions/$version")
        buildFileName = "../../build.gradle"
    }

}