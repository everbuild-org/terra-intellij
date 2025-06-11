package com.dfsek.terra.codetool.stringcomp

import com.intellij.psi.tree.IElementType
import org.jetbrains.annotations.NonNls

class StringcompElementType(debugName: @NonNls String) : IElementType(debugName, StringcompLanguage) {
    override fun toString(): String = "bs.${super.toString()}"
}