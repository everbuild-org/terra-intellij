package org.everbuild.terrascript.stringcomp.completion

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.util.ProcessingContext
import org.everbuild.terrascript.hasCommonPrefix

class MinecraftPrefixCompletionProvider : CompletionProvider<CompletionParameters>() {
    override fun addCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        resultSet: CompletionResultSet
    ) {
        if (parameters.position.textOffset != 0 && !hasCommonPrefix(parameters.position.text, "minecraft:")) {
            return
        }

        resultSet.addElement(
            LookupElementBuilder.create("minecraft:")
                .withPresentableText("minecraft:")
                .withBoldness(true)
        )
    }
}

