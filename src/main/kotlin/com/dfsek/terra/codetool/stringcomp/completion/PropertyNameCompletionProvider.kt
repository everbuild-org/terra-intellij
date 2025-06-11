package com.dfsek.terra.codetool.stringcomp.completion

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.icons.AllIcons
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.startOffset
import com.intellij.util.ProcessingContext
import com.dfsek.terra.codetool.stringcomp.data.MinecraftData
import com.dfsek.terra.codetool.stringcomp.psi.StringcompBlockstate

class PropertyNameCompletionProvider : CompletionProvider<CompletionParameters>() {
    override fun addCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        resultSet: CompletionResultSet
    ) {
        val charLeftOfToken = parameters.originalFile.text.getOrNull(parameters.position.startOffset - 1) ?: return
        if (charLeftOfToken != '[' && charLeftOfToken != ',') return
        val blockstate = PsiTreeUtil.getParentOfType(parameters.position, StringcompBlockstate::class.java) ?: return
        val blockId = blockstate.text.substringBefore('[').substringAfter(':')

        val blockData = MinecraftData.states[blockId] ?: return
        val applicableProps = blockData.properties.keys
            .filter { !parameters.originalFile.text.contains("$it=") }
        applicableProps.forEach { propName ->
            resultSet.addElement(
                LookupElementBuilder.create("$propName=")
                    .withPresentableText(propName)
                    .withIcon(AllIcons.Nodes.Property)
            )
        }

        if (applicableProps.isEmpty()) {
            resultSet.addElement(LookupElementBuilder.create("]").bold())
        }
    }
}