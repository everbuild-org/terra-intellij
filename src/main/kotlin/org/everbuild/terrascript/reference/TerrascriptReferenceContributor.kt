package org.everbuild.terrascript.reference

import com.intellij.openapi.util.TextRange
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceContributor
import com.intellij.psi.PsiReferenceProvider
import com.intellij.psi.PsiReferenceRegistrar
import com.intellij.util.ProcessingContext
import org.everbuild.terrascript.TerrascriptLanguage
import org.everbuild.terrascript.psi.TerrascriptCallExpression
import org.everbuild.terrascript.psi.TerrascriptExpression
import org.everbuild.terrascript.psi.TerrascriptVariableDeclaration
import org.everbuild.terrascript.psi.TesfTypes

class TerrascriptReferenceContributor : PsiReferenceContributor() {
    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(TesfTypes.ID),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<PsiReference> {
                    println("$element, $context, ${element.text}")
                    if (element.node.elementType == TesfTypes.ID) {
                        val parent = element.parent
                        if (parent is TerrascriptVariableDeclaration) {
                            return PsiReference.EMPTY_ARRAY
                        }

                        if (parent is TerrascriptCallExpression) {
                            return PsiReference.EMPTY_ARRAY
                        }

                        val textRange = TextRange(0, element.textLength)
                        return arrayOf(TerrascriptReference(element, textRange))
                    }

                    return PsiReference.EMPTY_ARRAY
                }
            },
            PsiReferenceRegistrar.HIGHER_PRIORITY
        )
    }
}