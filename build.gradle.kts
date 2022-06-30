import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import gg.essential.gradle.util.noServerRunConfigs
import gg.essential.gradle.util.setJvmDefault
import net.fabricmc.loom.task.RemapJarTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("com.github.johnrengelman.shadow")
    id("gg.essential.multi-version")
    id("gg.essential.defaults.repo")
    id("gg.essential.defaults.java")
    id("gg.essential.defaults.loom")
    `maven-publish`
    signing
    java
}

group = "dev.myosyn"
version = "1.0.0-PRE1"

repositories {
    mavenLocal()
    mavenCentral()
    gradlePluginPortal()
    maven(url = "https://repo.essential.gg/repository/maven-public")
    maven(url = "https://repo.essential.gg/repository/maven-releases")
    maven(url = "https://repo.sk1er.club/repository/maven-public/")
    maven(url = "https://repo.sk1er.club/repository/maven-releases/")
    maven(url = "https://maven.terraformersmc.com/releases/")
    maven(url = "https://jitpack.io")
}

preprocess {
    vars.put("MODERN", if (project.platform.mcMinor >= 16) 1 else 0)
}

java.withSourcesJar()
tasks.compileKotlin.setJvmDefault(if (platform.mcVersion >= 11400) "all" else "all-compatibility")
loom.noServerRunConfigs()

loom {
    runConfigs {
        named("client") {
            ideConfigGenerated(true)
        }
    }
    if (project.platform.isLegacyForge) {
        launchConfigs.named("client") {
            property("mixin.debug.export", "true")
            property("mixin.dumpTargetOnFailure", "true")
            arg("--tweakClass", "gg.essential.loader.stage0.EssentialSetupTweaker")
            arg("--mixin", "mixins.euphoria.json")
        }
    }
    mixin {
        defaultRefmapName.set("euphoria.mixins.refmap.json")
    }
}

val shadowMe: Configuration by configurations.creating {
    configurations.implementation.get().extendsFrom(this)
}

val shadowMeMod: Configuration by configurations.creating {
    configurations.modImplementation.get().extendsFrom(this)
}

dependencies {
    //shadowMe("dev.cbyrne:kdiscordipc:655c6fb") //What a shame
    implementation(kotlin("stdlib-jdk8", "1.6.21"))
    "com.github.LlamaLad7:MixinExtras:0.0.11".let {
        implementation(it)
        annotationProcessor(it)
        compileOnly(it)
    }
    shadowMe(platform("io.ktor:ktor-bom:2.0.3"))
    shadowMe("io.ktor:ktor-serialization-kotlinx-json-jvm")
    shadowMe("io.ktor:ktor-client-core-jvm")
    shadowMe("io.ktor:ktor-client-cio-jvm")
    shadowMe("io.ktor:ktor-client-content-negotiation-jvm")

    if (platform.isLegacyForge) {
        // You need this because otherwise you can't use mixin 0.8.x on 1.8.9
        // Also I didn't want to force this but oh well.
        compileOnly("gg.essential:essential-${platform}:2666") {
            // We need to exclude this so we can use Collision Handling ASM.
            exclude(module = "asm")
        }

    }

    if (platform.isFabric) {
        val fabricApiVersion = when(platform.mcVersion) {
            11404 -> "0.4.3+build.247-1.14"
            11502 -> "0.5.1+build.294-1.15"
            11604 -> "0.42.0+1.16"
            11701 -> "0.38.1+1.17"
            11801 -> "0.46.4+1.18"
            11802 -> "0.51.1+1.18.2"
            // 11900 -> "0.51.2+1.19"
            else -> throw GradleException("Invalid platform present: $platform")
        }

        val fabricApiModules = mutableListOf(
            "api-base",
            "keybindings-v0",
            "resource-loader-v0",
            "resource-loader-v0",
        )
        if (platform.mcVersion >= 11600) {
            fabricApiModules.add("key-binding-api-v1")
        }

        fabricApiModules.forEach { module ->
            modRuntime(modCompileOnly(fabricApi.module("fabric-$module", fabricApiVersion))!!)
        }

        modImplementation("net.fabricmc.fabric-api:fabric-api:${fabricApiVersion}")
        modImplementation("net.fabricmc:fabric-language-kotlin:1.8.1+kotlin.1.7.0")
        modImplementation("com.terraformersmc:modmenu:3.1.+")
        shadowMeMod(include("gg.essential:universalcraft-1.18.1-${platform.loaderStr}:213+pull-27")!!)
        shadowMeMod("gg.essential:vigilance-1.18.1-${platform.loaderStr}:215") {
            exclude(module = "kotlin-reflect")
            exclude(module = "kotlin-stdlib-jdk8")
            exclude(group = "net.fabricmc")
        }
    }
}

tasks.processResources {
    filesMatching(listOf("fabric.mod.json", "mcmod.info", "mixins.euphoria.json")) {
        filter { it.replace("\"com.example.examplemod.ExampleMod\"", "")}
    }
}

tasks {
    "shadowJar"(ShadowJar::class){
        configurations = listOf(shadowMe, shadowMeMod)
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
        relocate("com.llamalad7.mixinextras", "dev.shuuyu.euphoria.mixinextras")

        relocate("gg.essential.vigilance", "dev.shuuyu.euphoria.vigilance")
        relocate("gg.essential.elementa", "dev.shuuyu.euphoria.elementa")
        relocate("gg.essential.universalcraft", "dev.shuuyu.euphoria.universalcraft")

    }

    "remapJar"(RemapJarTask::class) {
        archiveBaseName.set("Euphoria-${platform.mcVersion}-${platform.loaderStr}-${project.version}")
    }

    "compileKotlin"(KotlinCompile::class) {
        kotlinOptions {
            kotlinOptions.freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"
            kotlinOptions.freeCompilerArgs += "-opt-in=kotlin.contracts.ExperimentalContracts"
            kotlinOptions.freeCompilerArgs += "-opt-in=kotlinx.serialization.ExperimentalSerializationApi"
            kotlinOptions.freeCompilerArgs += "-opt-in=kotlinx.serialization.InternalSerializationApi"
        }
    }
}

