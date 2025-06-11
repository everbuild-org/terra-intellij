package com.dfsek.terra.codetool.stringcomp.completion

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.icons.AllIcons
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.ProcessingContext
import com.dfsek.terra.codetool.stringcomp.data.MinecraftData
import com.dfsek.terra.codetool.stringcomp.psi.StringcompArgs
import com.dfsek.terra.codetool.stringcomp.psi.StringcompBlockstate

class PropertyValueCompletionProvider : CompletionProvider<CompletionParameters>() {
    override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, resultSet: CompletionResultSet) {
        val arg = PsiTreeUtil.getParentOfType(parameters.position, StringcompArgs::class.java) ?: return
        val blockstate = PsiTreeUtil.getParentOfType(arg, StringcompBlockstate::class.java) ?: return
        val blockId = blockstate.text.substringBefore('[').substringAfter(':')

        val propName = arg.parent.text.substringBefore("=")

        val blockData = MinecraftData.states[blockId] ?: return
        val propValues = blockData.properties[propName] ?: return

        propValues.forEach { propValue ->
            resultSet.addElement(
                LookupElementBuilder.create(propValue)
                    .withIcon(AllIcons.Nodes.Constant)
            )
        }
    }
}