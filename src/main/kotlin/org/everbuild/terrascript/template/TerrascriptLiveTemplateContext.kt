package org.everbuild.terrascript.template

import com.intellij.codeInsight.template.TemplateActionContext
import com.intellij.codeInsight.template.TemplateContextType
import org.everbuild.terrascript.completion.TerrascriptKeywordCompletionProvider


class TerrascriptLiveTemplateContext : TemplateContextType("Terrascript") {
    override fun isInContext(templateActionContext: TemplateActionContext): Boolean {
        println("asked to check context for")
        return true
        val currentElement = templateActionContext.file.findElementAt(templateActionContext.startOffset) ?: return true
        return TerrascriptKeywordCompletionProvider.isAtStartOfStatement(currentElement)
    }
}