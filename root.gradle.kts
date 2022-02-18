// Relies on preprocess to map to different versions of Minecraft, also did a funny with serialization

plugins {
    kotlin("jvm") version Dependencies.KOTLIN apply false
    id("fabric-loom") version Dependencies.FABRIC_LOOM apply false
    id("com.replaymod.preprocess") version Dependencies.PREPROCESSOR
}

configurations.register("compileClasspath")


//The versions we are trying to preprocess to
preprocess {
    // Latest Fabric version
    val fabric11801 = createNode("1.18.1-fabric", 11801, "yarn")
}