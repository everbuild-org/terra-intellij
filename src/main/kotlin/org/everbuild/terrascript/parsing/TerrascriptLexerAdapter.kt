package org.everbuild.terrascript.parsing

import com.intellij.lexer.FlexAdapter

class TerrascriptLexerAdapter : FlexAdapter(_TerrascriptLexer(null))