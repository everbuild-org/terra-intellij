package org.everbuild.terrascript.psi

import com.intellij.lang.ASTNode
import com.intellij.model.Pointer
import com.intellij.platform.backend.documentation.DocumentationResult
import com.intellij.platform.backend.documentation.DocumentationTarget
import com.intellij.platform.backend.presentation.TargetPresentation
import com.intellij.util.asSafely
import org.everbuild.terrascript.docs.TerrascriptDocumentationGenerator

open class TerrascriptDocumentedElementImpl(node: ASTNode) : TerrascriptPsiElementImpl(node), DocumentationTarget {
    override fun computePresentation(): TargetPresentation {
        return TargetPresentation.builder(this.text).presentation()
    }

    override fun createPointer(): Pointer<out DocumentationTarget> {
        return Pointer.hardPointer(this)
    }

    override fun computeDocumentation(): DocumentationResult? {
        val html = TerrascriptDocumentationGenerator
            .generateDocumentation(this.originalElement.asSafely<TerrascriptCallExpression>()?.id?.text ?: return null)
            ?: return null
        return DocumentationResult.documentation(html)
    }

    override fun toString(): String {
        return "doc/" + super.toString()
    }
}