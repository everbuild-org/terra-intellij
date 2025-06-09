package org.everbuild.terrascript.reference

import com.intellij.lang.refactoring.RefactoringSupportProvider
import com.intellij.psi.PsiElement
import org.everbuild.terrascript.psi.TerrascriptVariableDeclaration

class TerrascriptRefactoringSupportProvider : RefactoringSupportProvider() {
    override fun isMemberInplaceRenameAvailable(element: PsiElement, context: PsiElement?): Boolean {
        return element is TerrascriptVariableDeclaration
    }
}
