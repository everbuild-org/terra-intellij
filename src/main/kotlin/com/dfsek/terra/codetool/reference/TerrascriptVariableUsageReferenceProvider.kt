package com.dfsek.terra.codetool.reference

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceProvider
import com.intellij.util.ProcessingContext

class TerrascriptVariableUsageReferenceProvider : PsiReferenceProvider() {
    override fun getReferencesByElement(
        element: PsiElement,
        context: ProcessingContext
    ): Array<out PsiReference?> {
        val textRange = TextRange(0, element.textLength)
        return arrayOf(TerrascriptReference(element, textRange))
    }
}