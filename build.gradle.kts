import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import gg.essential.gradle.util.noServerRunConfigs
import gg.essential.gradle.util.setJvmDefault

plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("com.github.johnrengelman.shadow")
    // id("fabric-loom")
    // id("com.replaymod.preprocess")
    id("gg.essential.multi-version")
    id("gg.essential.defaults.repo")
    id("gg.essential.defaults.java")
    id("gg.essential.defaults.loom")
    `maven-publish`
    signing
    java
}

group = "dev.myosyn"
version = "1.0.0-PRE1" + "SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://repo.essential.gg/repository/maven-public")
    maven("https://repo.essential.gg/repository/maven-releases")
    maven("https://maven.terraformersmc.com/releases/")
    maven("https://jitpack.io")
}

preprocess {
    vars.put("MODERN", if (project.platform.mcMinor >= 16) 1 else 0)
}

java.withSourcesJar()
tasks.compileKotlin.setJvmDefault(if (platform.mcVersion >= 11400) "all" else "all-compatibility")
loom.noServerRunConfigs()

loom {
    runConfigs {
        named("client") {
            ideConfigGenerated(true)
        }
    }
    if (project.platform.isLegacyForge) {
        launchConfigs.named("client") {
            arg("--tweakClass", "gg.essential.loader.stage0.EssentialSetupTweaker")
        }
    }
}

val shade: Configuration by configurations.creating {
    isTransitive = false
}

val shadeMod: Configuration by configurations.creating {
    configurations.implementation.get().extendsFrom(this)
}

dependencies {

    annotationProcessor("com.github.LlamaLad7:MixinExtras:0.0.8")

    if (platform.isLegacyForge) {
        // You need this because otherwise you can't use mixin 0.8.x on 1.8.9
        // Also I didn't want to force this but oh well.
        compileOnly("gg.essential:essential-$platform:2656")
    }

    if (platform.isFabric) {
        val fabricApiVersion = when(platform.mcVersion) {
            11404 -> "0.4.3+build.247-1.14"
            11502 -> "0.5.1+build.294-1.15"
            11604 -> "0.42.0+1.16"
            11701 -> "0.38.1+1.17"
            11801 -> "0.46.4+1.18"
            11802 -> "0.51.1+1.18.2"
            // 11900 -> "0.51.2+1.19"
            else -> throw GradleException("Invalid platform $platform")
        }
        /*
        val fabricLoader = when(platform.mcVersion) {
            11404 -> ""
            else -> throw GradleException("Invalid mcVersion; $platform")
        }
        */
        /*
        val yarnMappings = when(platform.mcVersion) {
            11404 -> "1.14.4+build.18"
            11502 -> "1.15.2+build.17"
            11604 -> "1.16.4+build.9"
            11701 -> "1.17.1+build.65"
            11801 -> "1.18.1+build.22"
            11802 -> "1.18.2+build.3"
            else -> throw GradleException("Unsupported platform $platform")
        }
         */
        val fabricApiModules = mutableListOf(
            "api-base",
            "keybindings-v0",
            "resource-loader-v0",
            "resource-loader-v0",
        )

        if (platform.mcVersion >= 11600) {
            fabricApiModules.add("key-binding-api-v1")
        }

        modImplementation("net.fabricmc.fabric-api:fabric-api:${fabricApiVersion}")
        modImplementation("net.fabricmc:fabric-language-kotlin:1.7.3+kotlin.1.6.20")
        modImplementation("com.terraformersmc:modmenu:3.1.0")
    }

    implementation("com.github.LlamaLad7:MixinExtras:0.0.8")
}

tasks.processResources {

}

tasks {
    withType<ShadowJar> {
        if (platform.isLegacyForge) {
            manifest {
                attributes(
                    mapOf(
                        "FMLCorePluginContainsFMLMod" to true,
                        "ForceLoadAsMod" to true,
                        "MixinConfigs" to "mixins.euphoria.refmap.json",
                        "ModSide" to "CLIENT",
                        "TweakOrder" to 0
                    )
                )
            }
        }
        relocate("com.github.LlamaLad7:MixinExtras", "dev.myosyn.euphoria.mixinextras")
    }
}



// TODO: Add some publishing because why not
