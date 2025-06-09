package org.everbuild.terrascript.psi

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.Language
import org.everbuild.terrascript.TerrascriptLanguage

abstract class TerrascriptPsiElementImpl(node: ASTNode) : ASTWrapperPsiElement(node) {
    override fun getLanguage(): Language {
        return TerrascriptLanguage
    }
}