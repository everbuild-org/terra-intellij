package com.dfsek.terra.codetool.psi

import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.util.startOffset
import com.dfsek.terra.codetool.psi.impl.TerrascriptVariableDeclarationImpl

abstract class TerrascriptNamedElementImpl(node: ASTNode) : TerrascriptPsiElementImpl(node), TerrascriptNamedElement {
    override fun toString(): String {
        return "named/" + super.toString()
    }

    override fun getPresentation(): ItemPresentation? {
        return when (this) {
            is TerrascriptVariableDeclarationImpl -> TerrascriptVariableDeclarationPresentation(this)
            else -> super.getPresentation()
        }
    }

    override fun getTextOffset(): Int {
        return identifyingElement?.startOffset ?: super.getTextOffset()
    }
}
