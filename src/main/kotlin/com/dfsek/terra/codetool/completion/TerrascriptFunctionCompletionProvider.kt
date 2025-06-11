package com.dfsek.terra.codetool.completion

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.PrioritizedLookupElement
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.icons.AllIcons
import com.intellij.util.ProcessingContext
import com.dfsek.terra.codetool.psi.TerrascriptVariableDeclaration
import com.dfsek.terra.codetool.stdlib.FunctionDefinition
import com.dfsek.terra.codetool.stdlib.StandardLibrary

class TerrascriptFunctionCompletionProvider : CompletionProvider<CompletionParameters>() {
    override fun addCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        resultSet: CompletionResultSet
    ) {
        val parent = parameters.position.parent
        if (parent is TerrascriptVariableDeclaration) return
        StandardLibrary.functions.forEach { func ->
            resultSet.addElement(createFunctionLookupElement(func))
        }
    }

    private fun createFunctionLookupElement(func: FunctionDefinition): LookupElement {
        val parameters = func.arguments.joinToString(", ") { "${it.name}: ${it.type}" }

        return LookupElementBuilder.create(func.name)
            .withIcon(AllIcons.Nodes.Function)
            .withTailText("($parameters)")
            .withTypeText(func.returns)
            .withInsertHandler(FunctionInsertHandler(func.arguments.isNotEmpty()))
            .let { PrioritizedLookupElement.withPriority(it, 0.0) }
    }
}