package org.everbuild.terrascript.psi

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.Language
import com.intellij.psi.ContributedReferenceHost
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry
import com.intellij.psi.impl.source.tree.CompositeElement
import com.intellij.psi.util.PsiUtilCore
import org.everbuild.terrascript.TerrascriptLanguage

abstract class TerrascriptPsiElementImpl(node: ASTNode) : ASTWrapperPsiElement(node), ContributedReferenceHost {
    override fun getLanguage(): Language {
        return TerrascriptLanguage
    }

    override fun getReferences(): Array<PsiReference> = ReferenceProvidersRegistry.getReferencesFromProviders(this)

//    override fun getChildren(): Array<out PsiElement> {
//        var psiChild = firstChild
//        if (psiChild == null) return EMPTY_ARRAY
//
//        var result: MutableList<PsiElement?>? = null
//        while (psiChild != null) {
//            if (result == null) {
//                result = ArrayList()
//            }
//            result.add(psiChild)
//            psiChild = psiChild.nextSibling
//        }
//        return if (result == null) EMPTY_ARRAY else PsiUtilCore.toPsiElementArray(result)
//    }
}