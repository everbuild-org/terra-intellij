package org.everbuild.terrascript.completion

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.ProcessingContext
import org.everbuild.terrascript.psi.impl.TerrascriptStatementImpl

class TerrascriptKeywordCompletionProvider : CompletionProvider<CompletionParameters>() {
    override fun addCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        result: CompletionResultSet
    ) {
        val position = parameters.position

        if (isAtStartOfStatement(position)) {
            for (kw in KEYWORDS) {
                result.addElement(
                    LookupElementBuilder.create(kw)
                        .withBoldness(true)
                )
            }
        }
    }

    private fun isAtStartOfStatement(position: PsiElement): Boolean {
        val parent = PsiTreeUtil.getParentOfType<TerrascriptStatementImpl>(position) ?: return true
        return position.textRange.startOffset == parent.textRange.startOffset
    }

    companion object {
        val KEYWORDS = listOf(
            "if",
            "else",
            "while",
            "for",
            "return",
            "fail",
            "break",
            "continue",
            "str",
            "num",
            "bool"
        )
    }
}