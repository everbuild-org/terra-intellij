package com.dfsek.terra.codetool.reference

import com.intellij.lang.refactoring.RefactoringSupportProvider
import com.intellij.psi.PsiElement
import com.dfsek.terra.codetool.psi.TerrascriptVariableDeclaration

class TerrascriptRefactoringSupportProvider : RefactoringSupportProvider() {
    override fun isMemberInplaceRenameAvailable(element: PsiElement, context: PsiElement?): Boolean {
        return element is TerrascriptVariableDeclaration
    }
}
