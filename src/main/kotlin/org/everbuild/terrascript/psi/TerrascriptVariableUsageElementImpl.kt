package org.everbuild.terrascript.psi

import com.intellij.codeInsight.completion.PrioritizedLookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.model.Pointer
import com.intellij.platform.backend.documentation.DocumentationResult
import com.intellij.platform.backend.documentation.DocumentationTarget
import com.intellij.platform.backend.presentation.TargetPresentation
import com.intellij.psi.PsiComment
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.asSafely
import kotlin.text.isNotBlank

open class TerrascriptVariableUsageElementImpl(node: ASTNode) : TerrascriptPsiElementImpl(node), DocumentationTarget {
    override fun computePresentation(): TargetPresentation {
        return TargetPresentation.builder(this.text).presentation()
    }

    override fun createPointer(): Pointer<out DocumentationTarget> {
        return Pointer.hardPointer(this)
    }

    override fun computeDocumentation(): DocumentationResult? {
        val declaration = getDeclaration(this.originalElement ?: return null) ?: return null
        val docComment = getDocComment(declaration)
        val html = if (docComment != null) {
            "<b>${declaration.text}</b><br><br>$docComment"
        } else {
            "<b>${declaration.text}</b>"
        }
        return DocumentationResult.documentation(html)
    }

    private fun getDeclaration(element: PsiElement): PsiElement? {
        val file = element.containingFile
        val allDeclarations = PsiTreeUtil.findChildrenOfType(file, TerrascriptVariableDeclaration::class.java)
        val inScopeDeclarations = allDeclarations.filter { it.textOffset < element.textOffset }
        val name = element.text

        val lastDeclaration = inScopeDeclarations.mapNotNull { declaration ->
            val varName = declaration.name
            if (varName != null && varName.isNotBlank()) {
                return@mapNotNull declaration
            }
            return null
        }.sortedBy { it.textOffset }.lastOrNull { it.name == name }
        return lastDeclaration
    }

    private fun getDocComment(declaration: PsiElement): String? {
        val parent = declaration.parent ?: return null
        var leftParentSibling = parent.prevSibling ?: return null
        while (leftParentSibling is PsiWhiteSpace) {
            leftParentSibling = leftParentSibling.prevSibling ?: return null
        }
        if (leftParentSibling !is PsiComment) return null
        return leftParentSibling.text.removePrefix("//")
    }

    override fun toString(): String {
        return "var-doc/" + super.toString()
    }
}