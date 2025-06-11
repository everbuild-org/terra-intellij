package com.dfsek.terra.codetool.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import kotlin.text.isNotBlank
import com.dfsek.terra.codetool.psi.TerrascriptVariableDeclaration
import com.dfsek.terra.codetool.psi.TerrascriptVariableUsage
import com.dfsek.terra.codetool.syntax.TerrascriptSyntaxHighlighter

class TerrascriptUnusedVariableAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element !is TerrascriptVariableDeclaration) {
            return
        }

        val file = element.containingFile
        val allUsages = PsiTreeUtil.findChildrenOfType(file, TerrascriptVariableUsage::class.java)
        val inScopeUsages = allUsages.filter { it.textOffset > element.textOffset }
            .filter { usage -> usage.id.text == element.name }

        if (inScopeUsages.isEmpty() && element.text.isNotBlank()) {
            holder.newAnnotation(HighlightSeverity.WEAK_WARNING, "Unused variable")
                .range(element.id.textRange)
                .create()
        }
    }
}
