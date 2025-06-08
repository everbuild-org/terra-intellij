package org.everbuild.terrascript.parsing

import com.intellij.psi.tree.IElementType
import org.everbuild.terrascript.TerrascriptLanguage
import org.jetbrains.annotations.NonNls

class TerrascriptTokenType(debugName: @NonNls String) : IElementType(debugName, TerrascriptLanguage) {
    override fun toString(): String = "tesf.${super.toString()}"
}