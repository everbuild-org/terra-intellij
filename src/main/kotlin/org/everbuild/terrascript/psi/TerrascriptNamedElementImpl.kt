package org.everbuild.terrascript.psi

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import org.everbuild.terrascript.psi.impl.TerrascriptVariableDeclarationImpl

abstract class TerrascriptNamedElementImpl(node: ASTNode) : ASTWrapperPsiElement(node), PsiNameIdentifierOwner {
    override fun getNameIdentifier(): PsiElement? {
        if (node.psi.parent is TerrascriptCallExpression) return null
        return findChildByType(TesfTypes.ID)
    }

    override fun getName(): String? {
        return nameIdentifier?.text
    }

    override fun setName(name: String): PsiElement {
        val idNode = nameIdentifier?.node
        if (idNode != null) {
            val newId = TerrascriptPsiFactory(project).createIdentifier(name)
            node.replaceChild(idNode, newId.node)
        }
        return this
    }

    override fun toString(): String {
        return "named/" + super.toString()
    }

    override fun getPresentation(): ItemPresentation? {
        return when (this) {
            is TerrascriptVariableDeclarationImpl -> TerrascriptVariableDeclarationPresentation(this)
            else -> super.getPresentation()
        }
    }
}
