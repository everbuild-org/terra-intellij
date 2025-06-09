package org.everbuild.terrascript.psi

import com.intellij.psi.PsiElement
import org.everbuild.terrascript.psi.TerrascriptPsiFactory.createIdentifier

object TerrascriptPsiUtil {
    @JvmStatic
    fun getName(element: TerrascriptVariableDeclaration): String? {
        return element.getId().text
    }

    @JvmStatic
    fun setName(element: TerrascriptVariableDeclaration, newName: String): TerrascriptVariableDeclaration {
        val idNode = element.node.findChildByType(TesfTypes.ID)
        if (idNode != null) {
            val identifier = createIdentifier(element.project, newName)
            val newIdNode = identifier.node
            element.node.replaceChild(idNode, newIdNode)
        }
        return element
    }

    @JvmStatic
    fun getNameIdentifier(element: TerrascriptVariableDeclaration): PsiElement {
        return element.getId()
    }
}