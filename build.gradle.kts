import com.replaymod.gradle.preprocess.PreprocessTask

buildscript {
    repositories {
        mavenCentral()
        maven (url "https://files.minecraftforge.net/maven")
        maven (url "https://oss.sonatype.org/content/repositories/snapshots/")
        maven ("https://repo.sk1er.club/repository/maven-public/")
        maven("https://repo.sk1er.club/repository/maven-releases/")
        maven (url "https://jitpack.io")
    }

    dependencies {
        classpath('com.github.ReplayMod:ForgeGradle:48c4f0c6c7:all')
    }
}