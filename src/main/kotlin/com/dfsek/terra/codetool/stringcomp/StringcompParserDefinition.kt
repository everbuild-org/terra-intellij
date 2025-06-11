package com.dfsek.terra.codetool.stringcomp

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
import com.dfsek.terra.codetool.stringcomp.psi.StringcompTypes

class StringcompParserDefinition : ParserDefinition {
    override fun createLexer(p0: Project?): Lexer {
        return StringcompLexerAdapter()
    }
    override fun createParser(p0: Project?): PsiParser {
        return BlockstateParser()
    }
    override fun getFileNodeType(): IFileElementType {
        return file
    }
    override fun getCommentTokens(): TokenSet {
        return TokenSet.EMPTY
    }
    override fun getStringLiteralElements(): TokenSet {
        return TokenSet.EMPTY
    }
    override fun createElement(node: ASTNode): PsiElement {
        return StringcompTypes.Factory.createElement(node)
    }
    override fun getWhitespaceTokens(): TokenSet {
        return TokenSet.create(TokenType.WHITE_SPACE)
    }
    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return StringcompFile(viewProvider)
    }

    val file = IFileElementType(StringcompLanguage)
}

