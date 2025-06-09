package org.everbuild.terrascript.psi

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.util.startOffset
import org.everbuild.terrascript.psi.impl.TerrascriptVariableDeclarationImpl

abstract class TerrascriptNamedElementImpl(node: ASTNode) : ASTWrapperPsiElement(node), TerrascriptNamedElement {
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
