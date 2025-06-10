package org.everbuild.terrascript.psi

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.LiteralTextEscaper
import com.intellij.psi.PsiLanguageInjectionHost

abstract class TerrascriptInjectableLiteralImpl(node: ASTNode) : TerrascriptPsiElementImpl(node), TerrascriptInjectableLiteral {
    override fun toString(): String {
        return "injectable/" + super.toString()
    }

    override fun isValidHost(): Boolean {
        if (this is TerrascriptLiteral) return this.string != null
        return false
    }

    override fun updateText(s: String): PsiLanguageInjectionHost? {
        TerrascriptPsiFactory.createLiteral(project, s)
        return this
    }

    override fun createLiteralTextEscaper(): LiteralTextEscaper<out PsiLanguageInjectionHost?> {
        return object : LiteralTextEscaper<TerrascriptLiteral>(this as TerrascriptLiteral) {
            override fun decode(rangeInsideHost: TextRange, outChars: StringBuilder): Boolean {
                outChars.append(myHost.text, rangeInsideHost.startOffset, rangeInsideHost.endOffset)
                return true
            }

            override fun getOffsetInHost(offsetInDecoded: Int, rangeInsideHost: TextRange): Int {
                return rangeInsideHost.startOffset + offsetInDecoded
            }

            override fun isOneLine(): Boolean = true
        }
    }
}
