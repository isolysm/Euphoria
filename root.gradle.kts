plugins {
    kotlin("jvm") version "1.6.21" apply false
    kotlin("plugin.serialization") version "1.6.21" apply false

    id("com.github.johnrengelman.shadow") version "7.1.2" apply false
    id("gg.essential.multi-version.root") version "0.1.7"
    // id("com.replaymod.preprocess") version "73d8bed"
    // id("fabric-loom") version "0.12-SNAPSHOT" apply false
}

// configurations.register("compileClasspath")

//The versions we are trying to preprocess to
preprocess {
    // Latest Fabric (RELEASE) version
    val fabric11802 = createNode("1.18.2-fabric", 11802, "yarn")
    val fabric11801 = createNode("1.18.1-fabric", 11801, "yarn")

    // Conjunction points
    fabric11801.link(fabric11802, file("versions/1.18.1-1.18.2-mappings.txt"))
}
