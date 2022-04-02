plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("fabric-loom")
    id("com.replaymod.preprocess")
    id("com.github.johnrengelman.shadow")
    `maven-publish`
}

group = "dev.myosyn"
version = "1.0.0-PRE1" + "-SNAPSHOT"