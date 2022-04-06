plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("com.replaymod.preprocess")
    id("com.github.johnrengelman.shadow")
    id("fabric-loom")
    `maven-publish`
    java
}

group = "dev.myosyn"
version = "1.0.0-PRE1" + "SNAPSHOT"

val mcMajor: Int by extra
val mcMinor: Int by extra
val mcPatch: Int by extra
val mcVersion = mcMajor * 10000 + mcMinor * 100 + mcPatch
val mcVersionStr = listOf(mcMajor, mcMinor, mcPatch).dropLastWhile { it == 0 }.joinToString(".")
val loaderStr = loader.toString().toLowerCase()
val isFabric = loader == Loader.Fabric
val isForge = loader == Loader.Forge
val isModLauncher = loader == Loader.Forge && mcVersion >= 11400
val isLegacyForge = loader == Loader.Forge && mcVersion < 11400

// No betas have yet to be released for Quilt, so this is on hold.
// val isQuiltFabric = loader = Loader

dependencies {
    if (platform.isFabric) {
        val fabricApiVersion = when(platform.mcVersion) {
            11404 -> "0.4.3+build.247-1.14"
        }
    }
}

val javaVersion = when {
    mcVersion >= 11800 -> JavaVersion.VERSION_17
    mcVersion >= 11700 -> JavaVersion.VERSION_16
    mcVersion >= 11400 -> JavaVersion.VERSION_11
    else -> JavaVersion.VERSION_1_8
}
