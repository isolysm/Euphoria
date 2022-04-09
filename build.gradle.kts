plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("com.github.johnrengelman.shadow")
    id("gg.essential.multi-version")
    id("gg.essential.defaults.repo")
    id("gg.essential.defaults.java")
    id("gg.essential.defaults.loom")
    `maven-publish`
    java
}

group = "dev.myosyn"
version = "1.0.0-PRE1" + "SNAPSHOT"
