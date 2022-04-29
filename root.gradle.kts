plugins {
    kotlin("jvm") version "1.6.10" apply false
    kotlin("plugin.serialization") version "1.6.10" apply false

    id("com.github.johnrengelman.shadow") version "7.1.2" apply false
    id("gg.essential.multi-version.root")
    id("gg.essential.multi-version.api-validation")
    // id("com.replaymod.preprocess") version "73d8bed"
    // id("fabric-loom") version "0.12-SNAPSHOT" apply false
}

// configurations.register("compileClasspath")

//The versions we are trying to preprocess to
preprocess {
    // Latest Fabric (RELEASE) version
    val fabric11802 = createNode("1.18.2-fabric", 11802, "yarn")
    val fabric11801 = createNode("1.18.1-fabric", 11801, "yarn")

    // Latest Forge Mappings (If I even begin to start forge modding for later versions)
    // val forge11802 = createNode("1.18.2-forge", 11802, "srg")
    // val forge11801 = createNode("1.18.1-forge", 11801, "srg")

    // Legacy version mappings (Forge)
    // val forge11202 = createNode("1.12.2-forge", 11202, "srg")
    // val forge10809 = createNode("1.8.9-forge", 10809, "srg")

    // Conjunction points
    fabric11802.link(fabric11801, file("versions/1.18.1-1.18.2-mappings.txt"))
    // forge11802.link(forge11801)
    // forge11202.link(forge10809)
}
