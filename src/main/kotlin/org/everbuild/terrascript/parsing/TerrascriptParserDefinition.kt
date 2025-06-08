package org.everbuild.terrascript.parsing

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import org.everbuild.terrascript.TerrascriptLanguage
import org.everbuild.terrascript.psi.TerrascriptFile
import org.everbuild.terrascript.psi.TesfTypes

class TerrascriptParserDefinition : ParserDefinition {
    override fun createLexer(p0: Project?): Lexer {
        return TerrascriptLexerAdapter()
    }
    override fun createParser(p0: Project?): PsiParser {
        return TerrascriptParser()
    }
    override fun getFileNodeType(): IFileElementType {
        return file
    }
    override fun getCommentTokens(): TokenSet {
        return TokenSet.create(TesfTypes.COMMENT)
    }
    override fun getStringLiteralElements(): TokenSet {
        return TokenSet.create(TesfTypes.STRING)
    }
    override fun createElement(node: ASTNode): PsiElement {
        return TesfTypes.Factory.createElement(node)
    }
    override fun getWhitespaceTokens(): TokenSet {
        return TokenSet.create(TokenType.WHITE_SPACE)
    }
    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return TerrascriptFile(viewProvider)
    }

    val file = IFileElementType(TerrascriptLanguage)
}

