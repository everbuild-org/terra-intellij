package com.dfsek.terra.codetool.editor

import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.dfsek.terra.codetool.psi.TesfTypes

class TerrascriptBraceMatcher: PairedBraceMatcher {

    override fun getPairs(): Array<BracePair> {
        return PAIRS
    }

    override fun isPairedBracesAllowedBeforeType(
        lbraceType: com.intellij.psi.tree.IElementType,
        contextType: com.intellij.psi.tree.IElementType?
    ): Boolean {
        return true
    }

    override fun getCodeConstructStart(file: PsiFile, openingBraceOffset: Int): Int {
        return openingBraceOffset
    }

    companion object {
        private val PAIRS = arrayOf(
            BracePair(TesfTypes.LBRACE, TesfTypes.RBRACE, true),
            BracePair(TesfTypes.LPAREN, TesfTypes.RPAREN, false),
        )
    }
}
