package org.everbuild.terrascript


fun hasCommonPrefix(string: String, prefix: String): Boolean {
    if (string.isEmpty() || prefix.isEmpty()) return true
    if (string.length < prefix.length) {
        return prefix.startsWith(string)
    }
    return string.startsWith(prefix)
}