package com.dfsek.terra.codetool.stringcomp

import com.intellij.lang.Language

object StringcompLanguage : Language("terrascript_blockstate") {
    override fun getDisplayName(): String = "Blockstate"
    override fun isCaseSensitive() = true
}