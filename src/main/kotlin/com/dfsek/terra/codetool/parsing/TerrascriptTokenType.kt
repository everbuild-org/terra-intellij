package com.dfsek.terra.codetool.parsing

import com.intellij.psi.tree.IElementType
import com.dfsek.terra.codetool.TerrascriptLanguage
import org.jetbrains.annotations.NonNls

class TerrascriptTokenType(debugName: @NonNls String) : IElementType(debugName, TerrascriptLanguage) {
    override fun toString(): String = super.toString()
}