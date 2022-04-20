import gg.essential.gradle.util.noServerRunConfigs
import gg.essential.gradle.util.setJvmDefault
import org.jetbrains.kotlin.gradle.tasks.throwGradleExceptionIfError

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
    java
}

group = "dev.myosyn"
version = "1.0.0-PRE1" + "SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
}

preprocess {
    vars.put("MC", mcVersion)
}

java.withSourcesJar()
tasks.compileKotlin.setJvmDefault(if (platform.mcVersion >= 11400) "all" else "all-compatibility")
loom.noServerRunConfigs()

loom {

}

dependencies {
    if (platform.isLegacyForge) {

    }

    if (platform.isForge) {

    }

    if (platform.isFabric) {
        val fabricApiVersion = when(platform.mcVersion) {
            11404 -> "0.4.3+build.247-1.14"
            11502 -> "0.5.1+build.294-1.15"
            11604 -> "0.42.0+1.16"
            11701 -> "0.38.1+1.17"
            11801 -> "0.46.4+1.18"
            11802 -> "0.51.1+1.18.2"
            else -> throw GradleException("Invalid platform $platform")
        }
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
            "keybindings-v0"
        )

        fabricApiModules.forEach { module ->
            modImplementation("net.fabricmc.fabric-api:fabric-api:${fabricApiVersion}")
            modImplementation("net.fabricmc:fabric-language-kotlin:1.7.3+kotlin.1.6.20")
            // Apparently there's already a mapping present, great.
            // mappings("net.fabricmc:yarn::${yarnMappings}")
        }

    }

}

// TODO: Add some publishing because why not
