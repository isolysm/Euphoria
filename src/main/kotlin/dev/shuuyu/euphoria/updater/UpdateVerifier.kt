package dev.shuuyu.euphoria.updater

import dev.shuuyu.euphoria.Euphoria
import io.ktor.websocket.*
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


object UpdateVerifier {

    fun checkUpdate() {
        CoroutineScope(Dispatchers.IO + CoroutineName("EuphoriaUpdaterMoment")).launch {
            // val fetchLatestVersion =
            val currentVersionTag = Euphoria.VERSION

            val currentVersion = UpdateVersion(currentVersionTag)
            val latestVersion = UpdateVersion()
            if (currentVersion < latestVersion) {
                
            }
        }
    }

    class UpdateVersion {

    }
    enum class UpdateCandidate(val suffix: String) {
        RELEASE("REL"),
        RELEASECANDIDATE("RC"),
        PRERELEASE("PRE"),
        DEVELOPERBUILD("DEVBUILD")
    }
}
