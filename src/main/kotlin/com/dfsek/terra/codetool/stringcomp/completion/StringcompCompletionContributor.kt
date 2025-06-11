package com.dfsek.terra.codetool.stringcomp.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.patterns.PlatformPatterns
import com.dfsek.terra.codetool.stringcomp.StringcompFile
import com.dfsek.terra.codetool.stringcomp.psi.StringcompArgs
import com.dfsek.terra.codetool.stringcomp.psi.StringcompStatedefs
import com.dfsek.terra.codetool.stringcomp.psi.StringcompTypes

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