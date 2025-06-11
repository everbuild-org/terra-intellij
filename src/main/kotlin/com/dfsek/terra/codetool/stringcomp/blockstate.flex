package com.dfsek.terra.codetool.stringcomp;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.dfsek.terra.codetool.stringcomp.psi.StringcompTypes.*;

%%

%{
  public _BlockstateLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _BlockstateLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R

ID=[a-zA-Z_][a-zA-Z0-9_]*
VALUE=[a-zA-Z0-9_]*

%%
<YYINITIAL> {
  ":"                 { return COLON; }
  "["                 { return LBRACK; }
  "]"                 { return RBRACK; }
  "="                 { return EQ; }
  ","                 { return COMMA; }

  {ID}                { return ID; }
  {VALUE}             { return VALUE; }

}

[^] { return ANY; }
