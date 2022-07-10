plugins {
    kotlin("jvm") version "1.6.21" apply false
    kotlin("plugin.serialization") version "1.6.21" apply false

    id("com.github.johnrengelman.shadow") version "7.1.2" apply false
    id("gg.essential.multi-version.root") version "0.1.11"
    id("com.modrinth.minotaur") version "2.4.1" apply false
}

preprocess {
    val fabric11802 = createNode("1.18.2-fabric", 11802, "yarn")
    val fabric11801 = createNode("1.18.1-fabric", 11801, "yarn")
    val fabric11900 = createNode("1.19-fabric", 11900, "yarn")

    fabric11900.link(fabric11802)
    fabric11802.link(fabric11801)
}
