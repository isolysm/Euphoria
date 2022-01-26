// Relies on preprocess to map to different versions of Minecraft, also did a funny with serialization

plugins {
    kotlin("jvm") version VERSION.KOTLIN apply false
    kotlin("multiplatform") version VERSION.KOTLIN apply false
    kotlin("plugin.serialization") version VERSION.KOTLIN apply false
    id("com.replaymod.preprocess") version "7746c47"
    id("org.spongepowered.mixin) version "d5f9873d60"
}

configurations.register("compileClasspath")

preprocess {
    "1.18.1"(11801, "srg")
}