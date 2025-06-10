package org.everbuild.terrascript.completion

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.PrioritizedLookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.icons.AllIcons
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.ProcessingContext
import org.everbuild.terrascript.psi.TerrascriptVariableDeclaration

class TerrascriptVariableCompletionProvider : CompletionProvider<CompletionParameters>() {
    override fun addCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        resultSet: CompletionResultSet
    ) {
        val parent = parameters.position.parent
        if (parent is TerrascriptVariableDeclaration) return
        val position = parameters.position
        val file = position.containingFile

        val allDeclarations = PsiTreeUtil.findChildrenOfType(file, TerrascriptVariableDeclaration::class.java)
        val inScopeDeclarations = allDeclarations.filter { it.textOffset < position.textOffset }

        inScopeDeclarations.forEach { declaration ->
            val varName = declaration.name
            val varType = declaration.vartype.text

            if (varName != null && varName.isNotBlank()) {
                val lookupElement = LookupElementBuilder.create(varName)
                    .withIcon(AllIcons.Nodes.Variable)
                    .withTypeText(varType)
                    .let { PrioritizedLookupElement.withPriority(it, 100.0) }

                resultSet.addElement(lookupElement)
            }
        }
    }
}