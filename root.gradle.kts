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
    // Forge legacy versions
    val mc10809 = createNode("1.8.9", 10809, "srg")
    val mc10904 = createNode("1.9.4", 10904, "srg")
    val mc11102 = createNode("1.11.2", 11102, "srg")
    val mc11202 = createNode("1.12.2", 11201, "srg")

    // Fabric legacy and current versions
    val mc11701 = createNode("1.17.1", 11701, "yarn")
    val mc11801 = createNode("1.18.1", 11801, "yarn")
}