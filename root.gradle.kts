// Relies on preprocess to map to different versions of Minecraft, also did a funny with serialization

plugins {
    kotlin("jvm") version "1.6.10" apply false
    id("fabric-loom") version "0.5-SNAPSHOT" apply false
    id("com.replaymod.preprocess") version "24ac087"
}

configurations.register("compileClasspath")

preprocess {
    // Forge legacy versions
    "1.8.9"(10809, "srg")
}