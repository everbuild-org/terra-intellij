// This is a generated file. Not intended for manual editing.
package org.everbuild.terrascript.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.everbuild.terrascript.parsing.TerrascriptElementType;
import org.everbuild.terrascript.parsing.TerrascriptTokenType;
import org.everbuild.terrascript.psi.impl.*;

public interface TesfTypes {

  IElementType ARGUMENT_LIST = new TerrascriptElementType("ARGUMENT_LIST");
  IElementType ASSIGNMENT = new TerrascriptElementType("ASSIGNMENT");
  IElementType BLOCK = new TerrascriptElementType("BLOCK");
  IElementType CALL_EXPRESSION = new TerrascriptElementType("CALL_EXPRESSION");
  IElementType CONDITIONAL = new TerrascriptElementType("CONDITIONAL");
  IElementType CONTROL_FLOW_STATEMENT = new TerrascriptElementType("CONTROL_FLOW_STATEMENT");
  IElementType ELSE_BLOCK = new TerrascriptElementType("ELSE_BLOCK");
  IElementType EXPRESSION = new TerrascriptElementType("EXPRESSION");
  IElementType FOR_LOOP = new TerrascriptElementType("FOR_LOOP");
  IElementType ID_ASSIGNMENT = new TerrascriptElementType("ID_ASSIGNMENT");
  IElementType IF_STATEMENT = new TerrascriptElementType("IF_STATEMENT");
  IElementType LITERAL = new TerrascriptElementType("LITERAL");
  IElementType STATEMENT = new TerrascriptElementType("STATEMENT");
  IElementType VARIABLE_DECLARATION = new TerrascriptElementType("VARIABLE_DECLARATION");
  IElementType VARTYPE = new TerrascriptElementType("VARTYPE");
  IElementType WHILE_LOOP = new TerrascriptElementType("WHILE_LOOP");

  IElementType BOOL = new TerrascriptTokenType("bool");
  IElementType BREAK = new TerrascriptTokenType("break");
  IElementType COMMA = new TerrascriptTokenType(",");
  IElementType COMMENT = new TerrascriptTokenType("COMMENT");
  IElementType CONTINUE = new TerrascriptTokenType("continue");
  IElementType DIV = new TerrascriptTokenType("/");
  IElementType ELSE = new TerrascriptTokenType("else");
  IElementType EQ = new TerrascriptTokenType("=");
  IElementType EQEQ = new TerrascriptTokenType("==");
  IElementType FAIL = new TerrascriptTokenType("fail");
  IElementType FALSE = new TerrascriptTokenType("false");
  IElementType FOR = new TerrascriptTokenType("for");
  IElementType GE = new TerrascriptTokenType(">=");
  IElementType GT = new TerrascriptTokenType(">");
  IElementType ID = new TerrascriptTokenType("ID");
  IElementType IF = new TerrascriptTokenType("if");
  IElementType LBRACE = new TerrascriptTokenType("{");
  IElementType LE = new TerrascriptTokenType("<=");
  IElementType LPAREN = new TerrascriptTokenType("(");
  IElementType LT = new TerrascriptTokenType("<");
  IElementType L_AND = new TerrascriptTokenType("&&");
  IElementType L_NOT = new TerrascriptTokenType("!");
  IElementType L_OR = new TerrascriptTokenType("||");
  IElementType MINUS = new TerrascriptTokenType("-");
  IElementType MOD = new TerrascriptTokenType("%");
  IElementType MUL = new TerrascriptTokenType("*");
  IElementType NEQ = new TerrascriptTokenType("!=");
  IElementType NUM = new TerrascriptTokenType("num");
  IElementType NUMBER = new TerrascriptTokenType("NUMBER");
  IElementType PLUS = new TerrascriptTokenType("+");
  IElementType RBRACE = new TerrascriptTokenType("}");
  IElementType RETURN = new TerrascriptTokenType("return");
  IElementType RPAREN = new TerrascriptTokenType(")");
  IElementType SEMICOLON = new TerrascriptTokenType(";");
  IElementType STR = new TerrascriptTokenType("str");
  IElementType STRING = new TerrascriptTokenType("STRING");
  IElementType TRUE = new TerrascriptTokenType("true");
  IElementType WHILE = new TerrascriptTokenType("while");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARGUMENT_LIST) {
        return new TerrascriptArgumentListImpl(node);
      }
      else if (type == ASSIGNMENT) {
        return new TerrascriptAssignmentImpl(node);
      }
      else if (type == BLOCK) {
        return new TerrascriptBlockImpl(node);
      }
      else if (type == CALL_EXPRESSION) {
        return new TerrascriptCallExpressionImpl(node);
      }
      else if (type == CONDITIONAL) {
        return new TerrascriptConditionalImpl(node);
      }
      else if (type == CONTROL_FLOW_STATEMENT) {
        return new TerrascriptControlFlowStatementImpl(node);
      }
      else if (type == ELSE_BLOCK) {
        return new TerrascriptElseBlockImpl(node);
      }
      else if (type == EXPRESSION) {
        return new TerrascriptExpressionImpl(node);
      }
      else if (type == FOR_LOOP) {
        return new TerrascriptForLoopImpl(node);
      }
      else if (type == ID_ASSIGNMENT) {
        return new TerrascriptIdAssignmentImpl(node);
      }
      else if (type == IF_STATEMENT) {
        return new TerrascriptIfStatementImpl(node);
      }
      else if (type == LITERAL) {
        return new TerrascriptLiteralImpl(node);
      }
      else if (type == STATEMENT) {
        return new TerrascriptStatementImpl(node);
      }
      else if (type == VARIABLE_DECLARATION) {
        return new TerrascriptVariableDeclarationImpl(node);
      }
      else if (type == VARTYPE) {
        return new TerrascriptVartypeImpl(node);
      }
      else if (type == WHILE_LOOP) {
        return new TerrascriptWhileLoopImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
