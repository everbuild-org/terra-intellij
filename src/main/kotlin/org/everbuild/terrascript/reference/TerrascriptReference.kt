package org.everbuild.terrascript.reference

import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import com.intellij.psi.util.PsiTreeUtil
import org.everbuild.terrascript.psi.TerrascriptVariableDeclaration

class TerrascriptReference(element: PsiElement, textRange: TextRange) :
    PsiReferenceBase<PsiElement>(element, textRange), PsiPolyVariantReference {

    private val key: String = element.text

    override fun resolve(): PsiElement? {
        val resolveResults = multiResolve(false)
        return if (resolveResults.size == 1) resolveResults[0].element else null
    }

    override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
        val file = myElement.containingFile

        val declarations = PsiTreeUtil.findChildrenOfType(file, TerrascriptVariableDeclaration::class.java)
            .filter { it.idToken.text == key && it.textOffset < myElement.textOffset }

        val lastDeclaration = declarations.lastOrNull()

        return if (lastDeclaration != null) {
            arrayOf(PsiElementResolveResult(lastDeclaration))
        } else {
            ResolveResult.EMPTY_ARRAY
        }
    }
}