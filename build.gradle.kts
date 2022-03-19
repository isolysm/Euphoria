plugins {
    id("org.jetbrains.kotlin.jvm") apply false
    id("org.jetbrains.kotlin.plugin.serialization")
    id("com.replaymod.preprocess")
    id("com.github.johnrengelman.shadow")
    id("maven-publish")
}

group = "xyz.myosyn"
version = "1.0.0"

buildscript {
    val fabric = mcVersion >= 11400 && project.name.endsWith("-fabric")
    project.ext.mcVersion = mcVersion
    project.ext.mcVersionStr = mcVersionStr
    project.ext.mcPlatform = fabric ? 'fabric' : 'forge'
    project.ext.fabric = fabric

    repositories {
        mavenLocal()
        mavenCentral()
        maven {
            name = "fabric"
            url = uri ("https://maven.fabricmc.net/")
        }
        if(!fabric) {
            maven {
                name = "forge"
                url = uri("https://maven.minecraftforge.net")
            }
        }
    }
}

preprocess {
    vars.put("MC", mcVersion)
    vars.put("FABRIC", project.fabric ? 1 : 0)
    vars.put("FORGE", project.fabric ? 0 : 1)
}

apply(plugin = "kotlin")
apply(plugin = "com.replaymod.preprocess")
apply(plugin = "maven-publish")