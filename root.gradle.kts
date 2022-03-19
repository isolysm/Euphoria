// Relies on preprocess to map to different versions of Minecraft, also did a funny with serialization

plugins {
    kotlin("jvm") version "1.6.10" apply false
    kotlin("plugin.serialization") version "1.6.10" apply false
    id("com.github.johnrengelman.shadow") version "7.1.2" apply false

    id("com.replaymod.preprocess") version "0ab22d2"
    id("fabric-loom") version "0.11-SNAPSHOT" apply false
}

configurations.register("compileClasspath")

//The versions we are trying to preprocess to
preprocess {
    // Latest Fabric version
    "1.18.2-fabric"(11802, "yarn", file("versions/1.18.2-mappings.txt"))
}
