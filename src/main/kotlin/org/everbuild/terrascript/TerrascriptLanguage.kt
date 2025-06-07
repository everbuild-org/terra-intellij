package org.everbuild.terrascript

import com.intellij.lang.Language

object TerrascriptLanguage : Language("terrascript") {
    private fun readResolve(): Any = TerrascriptLanguage

    override fun getDisplayName(): String = "Terrascript"
    override fun isCaseSensitive() = true
}