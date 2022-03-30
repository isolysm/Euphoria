// Relies on preprocess to map to different versions of Minecraft, also did a funny with serialization
plugins {
    kotlin("jvm") version "1.6.10" apply false
    kotlin("plugin.serialization") version "1.6.10" apply false

    id("com.replaymod.preprocess") version "0ab22d2"
    id("fabric-loom") version "0.11-SNAPSHOT"
}

configurations.register("compileClasspath")

//The versions we are trying to preprocess to
preprocess {
    // Latest Fabric version
    val fabric11802 = createNode("1.18.2", 11802, "yarn")
    val fabric11801 = createNode("1.18.1", 11801, "yarn")

    //Legacy version mappings (Forge)
    // val forge11202 = createNode("1.12.2", 11202, "srg")
    // val forge10809 = createNode("1.8.9", 10809, "srg")

    fabric11802.link(fabric11801, file("versions/1.18.1-1.18.2-mappings.txt"))
    //forge11202.link(forge10809)
}
