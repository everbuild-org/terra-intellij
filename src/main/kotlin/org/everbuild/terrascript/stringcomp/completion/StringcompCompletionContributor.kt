package org.everbuild.terrascript.stringcomp.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.patterns.PlatformPatterns
import org.everbuild.terrascript.stringcomp.StringcompFile
import org.everbuild.terrascript.stringcomp.psi.StringcompArgs
import org.everbuild.terrascript.stringcomp.psi.StringcompStatedefs
import org.everbuild.terrascript.stringcomp.psi.StringcompTypes

class StringcompCompletionContributor : CompletionContributor() {
    init {
        extend(
            CompletionType.BASIC,
            PlatformPatterns.psiElement(),
            MinecraftPrefixCompletionProvider()
        )

        extend(
            CompletionType.BASIC,
            PlatformPatterns.psiElement(StringcompTypes.ID)
                .afterLeaf(PlatformPatterns.psiElement(StringcompTypes.COLON)),
            BlockNameCompletionProvider()
        )

        extend(
            CompletionType.BASIC, PlatformPatterns.psiElement(),
            PropertyNameCompletionProvider()
        )

        extend(
            CompletionType.BASIC, PlatformPatterns.psiElement(),
            PropertyValueCompletionProvider()
        )
    }
}