package com.dfsek.terra.codetool.completion

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.PrioritizedLookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiWhiteSpace
import com.intellij.util.ProcessingContext
import com.dfsek.terra.codetool.psi.TerrascriptExpression
import com.dfsek.terra.codetool.psi.TerrascriptFile
import com.dfsek.terra.codetool.psi.TerrascriptStatement

class TerrascriptKeywordCompletionProvider : CompletionProvider<CompletionParameters>() {
    override fun addCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        result: CompletionResultSet
    ) {
        val position = parameters.position

        if (isAtStartOfStatement(position)) {
            for (kw in GENERAL_KEYWORDS) {
                result.addElement(
                    LookupElementBuilder.create(kw + if (kw in SINGLE_LINE_KEYWORDS) ";" else "")
                        .withPresentableText(kw)
                        .withBoldness(true)
                        .let { PrioritizedLookupElement.withPriority(it, 10.0) }
                )
            }
        }
    }

    companion object {
        fun isAtStartOfStatement(position: PsiElement): Boolean {
            var previous = position.prevSibling
                ?: return position.parent is TerrascriptExpression || position.parent is TerrascriptFile
            while (previous is PsiWhiteSpace) {
                previous = previous.prevSibling
                    ?: return position.parent is TerrascriptExpression || position.parent is TerrascriptFile
            }
            if (previous.text == ";") return true
            if (previous is TerrascriptStatement) return true
            return false
        }

        // Get autocompleted to <kw>;
        val SINGLE_LINE_KEYWORDS = listOf(
            "return",
            "fail",
            "break",
            "continue",
        )

        val GENERAL_KEYWORDS = listOf(
            "if",
            "else",
            "while",
            "for",
            "str",
            "num",
            "bool"
        ) + SINGLE_LINE_KEYWORDS
    }
}