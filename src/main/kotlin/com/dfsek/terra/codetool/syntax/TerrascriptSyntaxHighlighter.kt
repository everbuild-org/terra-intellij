package com.dfsek.terra.codetool.syntax

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import com.dfsek.terra.codetool.parsing.TerrascriptLexerAdapter
import com.dfsek.terra.codetool.psi.TesfTypes

class TerrascriptSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer = TerrascriptLexerAdapter()

    override fun getTokenHighlights(tokenType: IElementType?): Array<out TextAttributesKey> = when (tokenType) {
        // Keywords
        TesfTypes.IF, TesfTypes.ELSE, TesfTypes.WHILE, TesfTypes.FOR,
        TesfTypes.RETURN, TesfTypes.FAIL, TesfTypes.BREAK, TesfTypes.CONTINUE,
        TesfTypes.STR, TesfTypes.NUM, TesfTypes.BOOL,
        TesfTypes.TRUE, TesfTypes.FALSE -> KEYWORD_KEYS

        // Literals
        TesfTypes.STRING -> STRING_KEYS
        TesfTypes.NUMBER -> NUMBER_KEYS

        // Comment
        TesfTypes.COMMENT -> COMMENT_KEYS

        // Operators
        TesfTypes.EQ, TesfTypes.PLUS, TesfTypes.MINUS, TesfTypes.MUL, TesfTypes.DIV,
        TesfTypes.MOD, TesfTypes.EQEQ, TesfTypes.NEQ, TesfTypes.GT, TesfTypes.LT,
        TesfTypes.GE, TesfTypes.LE, TesfTypes.L_AND, TesfTypes.L_OR, TesfTypes.L_NOT -> OPERATOR_KEYS

        // Punctuation
        TesfTypes.SEMICOLON -> SEMICOLON_KEYS
        TesfTypes.COMMA -> COMMA_KEYS
        TesfTypes.LPAREN, TesfTypes.RPAREN -> PARENTHESES_KEYS
        TesfTypes.LBRACE, TesfTypes.RBRACE -> BRACES_KEYS

        // Bad characters (errors)
        TokenType.BAD_CHARACTER -> BAD_CHAR_KEYS

        else -> EMPTY_KEYS
    }

    companion object {
        val KEYWORD: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
            "TERRASCRIPT_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD
        )
        val VARIABLE: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
            "TERRASCRIPT_VARIABLE", DefaultLanguageHighlighterColors.LOCAL_VARIABLE
        )
        val FUNCTION: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
            "TERRASCRIPT_FUNCTION", DefaultLanguageHighlighterColors.FUNCTION_CALL
        )
        val STRING: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
            "TERRASCRIPT_STRING", DefaultLanguageHighlighterColors.STRING
        )
        val NUMBER: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
            "TERRASCRIPT_NUMBER", DefaultLanguageHighlighterColors.NUMBER
        )
        val COMMENT: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
            "TERRASCRIPT_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT
        )
        val OPERATOR: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
            "TERRASCRIPT_OPERATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN
        )
        val SEMICOLON: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
            "TERRASCRIPT_SEMICOLON", DefaultLanguageHighlighterColors.SEMICOLON
        )
        val COMMA: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
            "TERRASCRIPT_COMMA", DefaultLanguageHighlighterColors.COMMA
        )
        val PARENTHESES: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
            "TERRASCRIPT_PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES
        )
        val BRACES: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
            "TERRASCRIPT_BRACES", DefaultLanguageHighlighterColors.BRACES
        )
        val BAD_CHARACTER: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
            "TERRASCRIPT_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER
        )

        private val KEYWORD_KEYS = arrayOf(KEYWORD)
        private val STRING_KEYS = arrayOf(STRING)
        private val NUMBER_KEYS = arrayOf(NUMBER)
        private val COMMENT_KEYS = arrayOf(COMMENT)
        private val OPERATOR_KEYS = arrayOf(OPERATOR)
        private val SEMICOLON_KEYS = arrayOf(SEMICOLON)
        private val COMMA_KEYS = arrayOf(COMMA)
        private val PARENTHESES_KEYS = arrayOf(PARENTHESES)
        private val BRACES_KEYS = arrayOf(BRACES)
        private val BAD_CHAR_KEYS = arrayOf(BAD_CHARACTER)
        private val EMPTY_KEYS = emptyArray<TextAttributesKey>()
    }
}