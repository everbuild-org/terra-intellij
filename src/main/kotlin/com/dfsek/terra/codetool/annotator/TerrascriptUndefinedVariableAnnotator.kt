package com.dfsek.terra.codetool.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import kotlin.text.isNotBlank
import com.dfsek.terra.codetool.psi.TerrascriptVariableDeclaration
import com.dfsek.terra.codetool.psi.TerrascriptVariableUsage

class TerrascriptUndefinedVariableAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element !is TerrascriptVariableUsage) {
            return
        }

        val file = element.containingFile

        val allDeclarations = PsiTreeUtil.findChildrenOfType(file, TerrascriptVariableDeclaration::class.java)
        val inScopeDeclarations = allDeclarations.filter { it.textOffset < element.textOffset }
            .filter { declaration -> declaration.name == element.text }

        if (inScopeDeclarations.isEmpty() && element.text.isNotBlank()) {
            holder.newAnnotation(HighlightSeverity.ERROR, "Unresolved variable: ${element.text}")
                .range(element.textRange)
                .create()
        }
    }
}
