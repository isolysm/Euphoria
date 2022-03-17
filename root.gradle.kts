// Relies on preprocess to map to different versions of Minecraft, also did a funny with serialization

plugins {
    kotlin("jvm") version Dependencies.KOTLIN apply false
    kotlin("plugin.serialization") version Dependencies.KOTLIN apply false

    id ("dev.architectury.loom") version "0.11.0-SNAPSHOT"
    id("com.replaymod.preprocess") version Dependencies.PREPROCESSOR
}

configurations.register("compileClasspath")


//The versions we are trying to preprocess to
preprocess {
    // Latest Fabric version
    val fabric11802 = createNode("1.18.2-fabric", 11802, "yarn")
}