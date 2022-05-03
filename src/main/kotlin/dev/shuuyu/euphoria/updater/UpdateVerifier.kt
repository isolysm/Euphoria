package dev.shuuyu.euphoria.updater


object UpdateVerifier {
    class UpdateChecker{

    }
    enum class UpdateCandidate(val suffix: String) {
        RELEASE("REL"),
        RELEASECANDIDATE("RC"),
        PRERELEASE("PRE"),
        ALPHARELEASE("APR"),
        DEVELOPERRELEASE("DEVREL")
    }
}
