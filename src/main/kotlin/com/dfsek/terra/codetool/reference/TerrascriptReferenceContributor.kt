package com.dfsek.terra.codetool.reference

import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.PsiReferenceContributor
import com.intellij.psi.PsiReferenceRegistrar
import com.dfsek.terra.codetool.psi.TerrascriptVariableUsage

class TerrascriptReferenceContributor : PsiReferenceContributor() {
    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(TerrascriptVariableUsage::class.java),
            TerrascriptVariableUsageReferenceProvider(),
            PsiReferenceRegistrar.HIGHER_PRIORITY
        )
    }
}