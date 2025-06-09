package org.everbuild.terrascript.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.patterns.PlatformPatterns.psiElement
import org.everbuild.terrascript.psi.TerrascriptVariableUsage

class TerrascriptCompletionContributor : CompletionContributor() {
    init {
        extend(
            CompletionType.BASIC,
            psiElement(),
            TerrascriptKeywordCompletionProvider()
        )

        extend(
            CompletionType.BASIC,
            psiElement().withParent(TerrascriptVariableUsage::class.java),
            TerrascriptVariableCompletionProvider()
        )
    }
}