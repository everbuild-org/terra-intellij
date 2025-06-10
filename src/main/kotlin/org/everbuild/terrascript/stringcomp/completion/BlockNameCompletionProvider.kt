package org.everbuild.terrascript.stringcomp.completion

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.icons.AllIcons
import com.intellij.util.ProcessingContext
import org.everbuild.terrascript.stringcomp.data.MinecraftData

class BlockNameCompletionProvider : CompletionProvider<CompletionParameters>() {
    override fun addCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        resultSet: CompletionResultSet
    ) {
        MinecraftData.blocks.forEach { blockName ->
            resultSet.addElement(
                LookupElementBuilder.create(blockName)
                    .withIcon(AllIcons.Nodes.Field)
            )
        }
    }
}