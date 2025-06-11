package com.dfsek.terra.codetool

import com.intellij.lang.Language

object TerrascriptLanguage : Language("terrascript") {
    override fun getDisplayName(): String = "Terrascript"
    override fun isCaseSensitive() = true
}