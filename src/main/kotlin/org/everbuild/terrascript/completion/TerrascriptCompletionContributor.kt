package org.everbuild.terrascript.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.patterns.PlatformPatterns.psiElement
import org.everbuild.terrascript.psi.TesfTypes

class TerrascriptCompletionContributor : CompletionContributor() {
    init {
        extend(
            CompletionType.BASIC,
            psiElement(),
            TerrascriptKeywordCompletionProvider()
        )

        extend(
            CompletionType.BASIC,
            psiElement(TesfTypes.ID),
            TerrascriptVariableCompletionProvider()
        )

        extend(
            CompletionType.BASIC,
            psiElement(TesfTypes.ID),
            TerrascriptFunctionCompletionProvider()
        )
    }
}