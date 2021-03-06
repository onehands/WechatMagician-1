package com.gh0u1l5.wechatmagician.util

// Version is a helper class for comparing version strings.
class Version(versionName: String) {

    val version: List<Int> = versionName.split('.').map(String::toInt)

    override fun hashCode(): Int{
        return version.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        return when (other) {
            null -> false
            !is Version -> false
            else -> this.version == other.version
        }
    }

    operator fun compareTo(other: Version): Int {
        var result = 0
        when {
            this.version.size > other.version.size -> result = 1
            this.version.size < other.version.size -> result = -1
        }

        var index = 0
        while (index < this.version.size && index < other.version.size) {
            when {
                this.version[index] > other.version[index] -> return 1
                this.version[index] < other.version[index] -> return -1
            }
            index++
        }

        return result
    }
}
