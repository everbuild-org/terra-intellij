// This is a generated file. Not intended for manual editing.
package org.everbuild.terrascript.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.everbuild.terrascript.psi.impl.*;

public interface TesfTypes {

  IElementType ARGUMENT_LIST = new IElementType("ARGUMENT_LIST", null);
  IElementType ASSIGNMENT = new IElementType("ASSIGNMENT", null);
  IElementType BLOCK = new IElementType("BLOCK", null);
  IElementType CONDITIONAL = new IElementType("CONDITIONAL", null);
  IElementType CONTROL_FLOW = new IElementType("CONTROL_FLOW", null);
  IElementType ELIF_BLOCK = new IElementType("ELIF_BLOCK", null);
  IElementType ELSE_BLOCK = new IElementType("ELSE_BLOCK", null);
  IElementType EXPRESSION = new IElementType("EXPRESSION", null);
  IElementType EXPRESSION_TAIL = new IElementType("EXPRESSION_TAIL", null);
  IElementType FOR_LOOP = new IElementType("FOR_LOOP", null);
  IElementType ID_ASSIGNMENT = new IElementType("ID_ASSIGNMENT", null);
  IElementType IF_BLOCK = new IElementType("IF_BLOCK", null);
  IElementType INLINE_STATEMENT = new IElementType("INLINE_STATEMENT", null);
  IElementType LITERAL = new IElementType("LITERAL", null);
  IElementType OPERATOR = new IElementType("OPERATOR", null);
  IElementType PRIMARY_EXPRESSION = new IElementType("PRIMARY_EXPRESSION", null);
  IElementType STATEMENT = new IElementType("STATEMENT", null);
  IElementType STATEMENT_START = new IElementType("STATEMENT_START", null);
  IElementType UNARY = new IElementType("UNARY", null);
  IElementType VARIABLE_DECLARATION = new IElementType("VARIABLE_DECLARATION", null);
  IElementType VARTYPE = new IElementType("VARTYPE", null);
  IElementType WHILE_LOOP = new IElementType("WHILE_LOOP", null);

  IElementType BOOL = new IElementType("bool", null);
  IElementType BREAK = new IElementType("break", null);
  IElementType COMMA = new IElementType(",", null);
  IElementType COMMENT = new IElementType("COMMENT", null);
  IElementType CONTINUE = new IElementType("continue", null);
  IElementType DIV = new IElementType("/", null);
  IElementType ELSE = new IElementType("else", null);
  IElementType EQ = new IElementType("=", null);
  IElementType EQEQ = new IElementType("==", null);
  IElementType FAIL = new IElementType("fail", null);
  IElementType FALSE = new IElementType("false", null);
  IElementType FOR = new IElementType("for", null);
  IElementType GE = new IElementType("<=", null);
  IElementType GT = new IElementType("<", null);
  IElementType ID = new IElementType("ID", null);
  IElementType IF = new IElementType("if", null);
  IElementType LBRACE = new IElementType("{", null);
  IElementType LE = new IElementType(">=", null);
  IElementType LPAREN = new IElementType("(", null);
  IElementType LT = new IElementType(">", null);
  IElementType L_AND = new IElementType("&&", null);
  IElementType L_NOT = new IElementType("!", null);
  IElementType L_OR = new IElementType("||", null);
  IElementType MINUS = new IElementType("-", null);
  IElementType MOD = new IElementType("%", null);
  IElementType MUL = new IElementType("*", null);
  IElementType NEQ = new IElementType("!=", null);
  IElementType NUM = new IElementType("num", null);
  IElementType NUMBER = new IElementType("NUMBER", null);
  IElementType PLUS = new IElementType("+", null);
  IElementType RBRACE = new IElementType("}", null);
  IElementType RETURN = new IElementType("return", null);
  IElementType RPAREN = new IElementType(")", null);
  IElementType SEMICOLON = new IElementType(";", null);
  IElementType STR = new IElementType("str", null);
  IElementType STRING = new IElementType("STRING", null);
  IElementType TRUE = new IElementType("true", null);
  IElementType WHILE = new IElementType("while", null);

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
      else if (type == CONDITIONAL) {
        return new TerrascriptConditionalImpl(node);
      }
      else if (type == CONTROL_FLOW) {
        return new TerrascriptControlFlowImpl(node);
      }
      else if (type == ELIF_BLOCK) {
        return new TerrascriptElifBlockImpl(node);
      }
      else if (type == ELSE_BLOCK) {
        return new TerrascriptElseBlockImpl(node);
      }
      else if (type == EXPRESSION) {
        return new TerrascriptExpressionImpl(node);
      }
      else if (type == EXPRESSION_TAIL) {
        return new TerrascriptExpressionTailImpl(node);
      }
      else if (type == FOR_LOOP) {
        return new TerrascriptForLoopImpl(node);
      }
      else if (type == ID_ASSIGNMENT) {
        return new TerrascriptIdAssignmentImpl(node);
      }
      else if (type == IF_BLOCK) {
        return new TerrascriptIfBlockImpl(node);
      }
      else if (type == INLINE_STATEMENT) {
        return new TerrascriptInlineStatementImpl(node);
      }
      else if (type == LITERAL) {
        return new TerrascriptLiteralImpl(node);
      }
      else if (type == OPERATOR) {
        return new TerrascriptOperatorImpl(node);
      }
      else if (type == PRIMARY_EXPRESSION) {
        return new TerrascriptPrimaryExpressionImpl(node);
      }
      else if (type == STATEMENT) {
        return new TerrascriptStatementImpl(node);
      }
      else if (type == STATEMENT_START) {
        return new TerrascriptStatementStartImpl(node);
      }
      else if (type == UNARY) {
        return new TerrascriptUnaryImpl(node);
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
