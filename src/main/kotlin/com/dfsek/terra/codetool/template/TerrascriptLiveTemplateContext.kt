package com.dfsek.terra.codetool.template

import com.intellij.codeInsight.template.TemplateActionContext
import com.intellij.codeInsight.template.TemplateContextType

class TerrascriptLiveTemplateContext : TemplateContextType("Terrascript") {
    override fun isInContext(templateActionContext: TemplateActionContext): Boolean {
        return true
    }
}