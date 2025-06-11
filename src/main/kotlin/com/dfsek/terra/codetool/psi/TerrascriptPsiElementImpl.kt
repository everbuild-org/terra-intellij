package com.dfsek.terra.codetool.psi

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.Language
import com.intellij.psi.ContributedReferenceHost
import com.intellij.psi.PsiReference
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry
import com.dfsek.terra.codetool.TerrascriptLanguage

abstract class TerrascriptPsiElementImpl(node: ASTNode) : ASTWrapperPsiElement(node), ContributedReferenceHost {
    override fun getLanguage(): Language {
        return TerrascriptLanguage
    }

    override fun getReferences(): Array<PsiReference> = ReferenceProvidersRegistry.getReferencesFromProviders(this)
}