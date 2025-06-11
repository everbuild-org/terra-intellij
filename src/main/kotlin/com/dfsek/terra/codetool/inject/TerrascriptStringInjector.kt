package com.dfsek.terra.codetool.inject

import com.intellij.openapi.util.TextRange
import com.intellij.psi.InjectedLanguagePlaces
import com.intellij.psi.LanguageInjector
import com.intellij.psi.PsiLanguageInjectionHost
import com.dfsek.terra.codetool.TerrascriptLanguage
import com.dfsek.terra.codetool.hasCommonPrefix
import com.dfsek.terra.codetool.psi.TerrascriptLiteral
import com.dfsek.terra.codetool.stringcomp.StringcompLanguage

class TerrascriptStringInjector : LanguageInjector {
    override fun getLanguagesToInject(
        host: PsiLanguageInjectionHost,
        place: InjectedLanguagePlaces
    ) {
        if (!(host.language.isKindOf(TerrascriptLanguage))) {
            return
        }

        if (host !is TerrascriptLiteral || host.string == null) {
            return
        }

        val rangeInsideQuotes = TextRange(1, (host as PsiLanguageInjectionHost).textLength - 1)
        // IntellijIdeaRulezzz is a default added token for autocompletion, so it may be shoved in here and can be ignored
        val stringContent = host.text.substring(1, host.textLength - 1).replace("IntellijIdeaRulezzz", "").trim()

        if (hasCommonPrefix(stringContent, "minecraft:")) {
            place.addPlace(
                StringcompLanguage,
                rangeInsideQuotes,
                null,
                null
            )
        }
    }

}
