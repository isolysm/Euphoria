plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("com.github.johnrengelman.shadow")
    `maven-publish`
    java

    // The dependencies we desperately need because I am a clown and cannot do anything correctly
    id("fabric-loom")
    id("com.replaymod.preprocess")
}

group = "dev.myosyn"
version = "1.0.0-PRE1" + "SNAPSHOT"


