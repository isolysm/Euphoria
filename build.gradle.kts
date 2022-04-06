import gg.essential.gradle.util.prebundle
import gg.essential.gradle.util.RelocationTransform.Companion.registerRelocationAttribute

plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("gg.essential.multi-version")
    id("gg.essential.defaults")
    `maven-publish`
    java
}

val relocated = registerRelocationAttribute("relocate-ancient-gson") {
    relocate("com.google.gson", "com.example.lib.gson")
}

val ancientGson by configurations.creating {
    attributes { attribute(relocated, true) }
}

dependencies {
    val bothLibs by configurations.creating
    // If you are depending on a multi-version library following the same scheme as the Essential libraries (that is
    // e.g. `elementa-1.8.9-forge`), you can `toString` `platform` directly to get the respective artifact id.
    modImplementation("gg.essential:elementa-$platform:428")
    bothLibs("com.google.code.gson:gson:2.0.0")
    bothLibs("com.example:libRequiringAnAncientGson:1.0.0")
    implementation(prebundle(bothLibs))
    implementation(prebundle(ancientGson))
}

tasks.processResources {
    // Expansions are already set up for `version` (or `file.jarVersion`) and `mcVersionStr`.
    // You do not need to set those up manually.
}

loom {
    // If you need to use a tweaker on legacy (1.12.2 and below) forge:
    if (platform.isLegacyForge) {
        launchConfigs.named("client") {
            arg("--tweakClass", "gg.essential.loader.stage0.EssentialSetupTweaker")
            // And maybe a core mod?
            property("fml.coreMods.load", "com.example.asm.CoreMod")
        }
    }
    // Mixin on forge? (for legacy forge you will still need to register a tweaker to set up mixin)
    if (platform.isForge) {
        forge {
            mixinConfig("euphoria.mixins.json")
            // And maybe an access transformer?
            // Though try to avoid these, cause they are not automatically translated to Fabric's access widener
            accessTransformer(project.parent.file("src/main/resources/example_at.cfg"))
        }
    }
}