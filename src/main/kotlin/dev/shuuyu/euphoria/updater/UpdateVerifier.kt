package dev.shuuyu.euphoria.updater

import io.ktor.client.statement.*
import io.ktor.websocket.*
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch



object UpdateVerifier {
    fun checkUpdate() {
        CoroutineScope(Dispatchers.IO + CoroutineName("EuphoriaUpdaterMoment")).launch {

        }
    }
    enum class UpdateCandidate(val suffix: String) {
        RELEASE("REL"),
        RELEASECANDIDATE("RC"),
        PRERELEASE("PRE"),
        DEVELOPERBUILD("DEVBUILD")
    }
}
