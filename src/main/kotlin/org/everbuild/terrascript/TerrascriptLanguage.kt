package org.everbuild.terrascript

import com.intellij.lang.Language

object TerrascriptLanguage : Language("terrascript") {
    override fun getDisplayName(): String = "Terrascript"
    override fun isCaseSensitive() = true
}