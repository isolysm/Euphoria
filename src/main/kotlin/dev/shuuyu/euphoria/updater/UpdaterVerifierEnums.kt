package dev.shuuyu.euphoria.updater

enum class UpdateCandidate(val suffix: String) {
    RELEASE("REL"),
    RELEASECANDIDATE("RC"),
    PRERELEASE("PRE"),
    DEVELOPERBUILD("DEVBUILD")
}
