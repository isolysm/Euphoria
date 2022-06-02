package dev.shuuyu.euphoria.updater

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


object UpdateVerifier {

    fun checkUpdate() {
        CoroutineScope(Dispatchers.IO + CoroutineName("EuphoriaUpdaterMoment")).launch {

        }
    }

    class UpdateVersion(currentVersionTag: String) {

    }
    enum class UpdateCandidate(val suffix: String) {
        RELEASE("REL"),
        RELEASECANDIDATE("RC"),
        PRERELEASE("PRE"),
        DEVELOPERBUILD("DEVBUILD")
    }
}

class UpdateVersion(private val versionString: String): Comparable<UpdateVersion> {
    companion object {
        val regex = Regex("^(?<version>[\\d.]+)-?(?<type>\\D+)?(?<typever>\\d+\\.?\\d*)?\$")
    }

    private val matched by lazy {
        regex.find(versionString)
    }

    override fun compareTo(other: UpdateVersion): Int {
        TODO("Not yet implemented")
    }
}
