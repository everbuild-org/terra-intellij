package com.dfsek.terra.codetool.docs

import com.intellij.platform.backend.documentation.DocumentationTarget
import com.intellij.platform.backend.documentation.DocumentationTargetProvider
import com.intellij.psi.PsiFile
import com.intellij.psi.util.parents

class TerrascriptDocumentationTargetProvider : DocumentationTargetProvider {
    override fun documentationTargets(
        file: PsiFile,
        offset: Int
    ): List<DocumentationTarget> {
        val element = file.findElementAt(offset) ?: return emptyList()
        return element.parents(true).filterIsInstance<DocumentationTarget>().toList()
    }
}