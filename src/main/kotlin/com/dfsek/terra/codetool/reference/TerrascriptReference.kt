package com.dfsek.terra.codetool.reference

import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import com.intellij.psi.util.PsiTreeUtil
import com.dfsek.terra.codetool.psi.TerrascriptVariableDeclaration

class TerrascriptReference(element: PsiElement, textRange: TextRange) : PsiPolyVariantReferenceBase<PsiElement>(element, textRange) {

    private val key: String = element.text

    override fun resolve(): PsiElement? {
        val resolveResults = multiResolve(false)
        return if (resolveResults.size == 1) resolveResults[0].element else null
    }

    override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
        val file = myElement.containingFile

        val declarations = PsiTreeUtil.findChildrenOfType(file, TerrascriptVariableDeclaration::class.java)
            .filter { it.id.text == key && it.textOffset < myElement.textOffset }

        val lastDeclaration = declarations.lastOrNull()

        return if (lastDeclaration != null) {
            arrayOf(PsiElementResolveResult(lastDeclaration))
        } else {
            ResolveResult.EMPTY_ARRAY
        }
    }
}