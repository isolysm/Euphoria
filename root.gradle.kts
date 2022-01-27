// Relies on preprocess to map to different versions of Minecraft, also did a funny with serialization

plugins {
    kotlin("jvm") version "1.6.10" apply false;
    kotlin("multiplatform") version "1.6.10" apply false;
    id("com.replaymod.preprocess") version "7746c47";
    id("net.minecraftforge.gradle.forge") version ""
    id("org.spongepowered.mixin") version "d5f9873d60"
    java
}

configurations.register("compileClasspath")

preprocess {
    "1.8.9"(10809, "srg")
    "1.12.2"(11202, "srg")
    "1.17.1"(11701, "srg")
    "1.18.1"(11801, "srg")
}