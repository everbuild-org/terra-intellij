// This is a generated file. Not intended for manual editing.
package org.everbuild.terrascript.parsing;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static org.everbuild.terrascript.psi.TesfTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class TerrascriptParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return terrascriptFile(b, l + 1);
  }

  /* ********************************************************** */
  // expression (COMMA argument_list)?
  public static boolean argument_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENT_LIST, "<argument list>");
    r = expression(b, l + 1);
    r = r && argument_list_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA argument_list)?
  private static boolean argument_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list_1")) return false;
    argument_list_1_0(b, l + 1);
    return true;
  }

  // COMMA argument_list
  private static boolean argument_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && argument_list(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // EQ expression
  public static boolean assignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSIGNMENT, "<assignment>");
    r = consumeToken(b, EQ);
    r = r && expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // statement | LBRACE statement* RBRACE
  public static boolean block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BLOCK, "<block>");
    r = statement(b, l + 1);
    if (!r) r = block_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LBRACE statement* RBRACE
  private static boolean block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && block_1_1(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // statement*
  private static boolean block_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_1_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "block_1_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // if_block (elif_block*)? else_block?
  public static boolean conditional(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONDITIONAL, "<conditional>");
    r = if_block(b, l + 1);
    r = r && conditional_1(b, l + 1);
    r = r && conditional_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (elif_block*)?
  private static boolean conditional_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional_1")) return false;
    conditional_1_0(b, l + 1);
    return true;
  }

  // elif_block*
  private static boolean conditional_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional_1_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!elif_block(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "conditional_1_0", c)) break;
    }
    return true;
  }

  // else_block?
  private static boolean conditional_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional_2")) return false;
    else_block(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // RETURN | FAIL | BREAK | CONTINUE
  public static boolean control_flow(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "control_flow")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONTROL_FLOW, "<control flow>");
    r = consumeToken(b, RETURN);
    if (!r) r = consumeToken(b, FAIL);
    if (!r) r = consumeToken(b, BREAK);
    if (!r) r = consumeToken(b, CONTINUE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ELSE if_block
  public static boolean elif_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elif_block")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ELIF_BLOCK, "<elif block>");
    r = consumeToken(b, ELSE);
    r = r && if_block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ELSE block
  public static boolean else_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "else_block")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ELSE_BLOCK, "<else block>");
    r = consumeToken(b, ELSE);
    r = r && block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // primary_expression expression_tail?
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = primary_expression(b, l + 1);
    r = r && expression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // expression_tail?
  private static boolean expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_1")) return false;
    expression_tail(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // operator primary_expression expression_tail?
  public static boolean expression_tail(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_tail")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION_TAIL, "<expression tail>");
    r = operator(b, l + 1);
    r = r && primary_expression(b, l + 1);
    r = r && expression_tail_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // expression_tail?
  private static boolean expression_tail_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_tail_2")) return false;
    expression_tail(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // FOR LPAREN inline_statement SEMICOLON inline_statement SEMICOLON inline_statement RPAREN block
  public static boolean for_loop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_loop")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FOR_LOOP, "<for loop>");
    r = consumeTokens(b, 0, FOR, LPAREN);
    r = r && inline_statement(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    r = r && inline_statement(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    r = r && inline_statement(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ID EQ expression
  public static boolean id_assignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id_assignment")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ID_ASSIGNMENT, "<id assignment>");
    r = consumeTokens(b, 0, ID, EQ);
    r = r && expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IF LPAREN expression RPAREN block
  public static boolean if_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_block")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IF_BLOCK, "<if block>");
    r = consumeTokens(b, 0, IF, LPAREN);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // variable_declaration
  //                    | id_assignment
  //                    | expression
  public static boolean inline_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inline_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INLINE_STATEMENT, "<inline statement>");
    r = variable_declaration(b, l + 1);
    if (!r) r = id_assignment(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // NUMBER | STRING | TRUE | FALSE
  public static boolean literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL, "<literal>");
    r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // L_AND | L_OR
  //            | PLUS | MINUS | MUL | DIV | MOD
  //            | EQEQ | NEQ | LT | GT | LE | GE
  public static boolean operator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OPERATOR, "<operator>");
    r = consumeToken(b, L_AND);
    if (!r) r = consumeToken(b, L_OR);
    if (!r) r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, MUL);
    if (!r) r = consumeToken(b, DIV);
    if (!r) r = consumeToken(b, MOD);
    if (!r) r = consumeToken(b, EQEQ);
    if (!r) r = consumeToken(b, NEQ);
    if (!r) r = consumeToken(b, LT);
    if (!r) r = consumeToken(b, GT);
    if (!r) r = consumeToken(b, LE);
    if (!r) r = consumeToken(b, GE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // literal
  //                      | ID LPAREN argument_list? RPAREN   // fn call
  //                      | LPAREN expression RPAREN          // Group
  //                      | unary primary_expression          // Unary operation
  //                      | ID
  public static boolean primary_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PRIMARY_EXPRESSION, "<primary expression>");
    r = literal(b, l + 1);
    if (!r) r = primary_expression_1(b, l + 1);
    if (!r) r = primary_expression_2(b, l + 1);
    if (!r) r = primary_expression_3(b, l + 1);
    if (!r) r = consumeToken(b, ID);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ID LPAREN argument_list? RPAREN
  private static boolean primary_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_expression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ID, LPAREN);
    r = r && primary_expression_1_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // argument_list?
  private static boolean primary_expression_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_expression_1_2")) return false;
    argument_list(b, l + 1);
    return true;
  }

  // LPAREN expression RPAREN
  private static boolean primary_expression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_expression_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // unary primary_expression
  private static boolean primary_expression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_expression_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = unary(b, l + 1);
    r = r && primary_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // control_flow SEMICOLON
  //             | variable_declaration SEMICOLON
  //             | id_assignment SEMICOLON
  //             | conditional
  //             | while_loop
  //             | for_loop
  //             | expression SEMICOLON
  //             | COMMENT
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = statement_0(b, l + 1);
    if (!r) r = statement_1(b, l + 1);
    if (!r) r = statement_2(b, l + 1);
    if (!r) r = conditional(b, l + 1);
    if (!r) r = while_loop(b, l + 1);
    if (!r) r = for_loop(b, l + 1);
    if (!r) r = statement_6(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // control_flow SEMICOLON
  private static boolean statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = control_flow(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // variable_declaration SEMICOLON
  private static boolean statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = variable_declaration(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // id_assignment SEMICOLON
  private static boolean statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = id_assignment(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // expression SEMICOLON
  private static boolean statement_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // STR | NUM | TRUE | FALSE | ID | IF | FOR | WHILE | RETURN | FAIL | BREAK | CONTINUE | COMMENT
  public static boolean statement_start(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_start")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT_START, null);
    r = consumeToken(b, STR);
    if (!r) r = consumeToken(b, NUM);
    if (!r) r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    if (!r) r = consumeToken(b, ID);
    if (!r) r = consumeToken(b, IF);
    if (!r) r = consumeToken(b, FOR);
    if (!r) r = consumeToken(b, WHILE);
    if (!r) r = consumeToken(b, RETURN);
    if (!r) r = consumeToken(b, FAIL);
    if (!r) r = consumeToken(b, BREAK);
    if (!r) r = consumeToken(b, CONTINUE);
    if (!r) r = consumeToken(b, COMMENT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // statement*
  static boolean terrascriptFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "terrascriptFile")) return false;
    Marker m = enter_section_(b, l, _NONE_);
    while (true) {
      int c = current_position_(b);
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "terrascriptFile", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // L_NOT | MINUS
  public static boolean unary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNARY, "<unary>");
    r = consumeToken(b, L_NOT);
    if (!r) r = consumeToken(b, MINUS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // vartype ID assignment?
  public static boolean variable_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_declaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_DECLARATION, "<variable declaration>");
    r = vartype(b, l + 1);
    r = r && consumeToken(b, ID);
    r = r && variable_declaration_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // assignment?
  private static boolean variable_declaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_declaration_2")) return false;
    assignment(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // STR | NUM | BOOL
  public static boolean vartype(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vartype")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARTYPE, "<vartype>");
    r = consumeToken(b, STR);
    if (!r) r = consumeToken(b, NUM);
    if (!r) r = consumeToken(b, BOOL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // WHILE LPAREN expression RPAREN block
  public static boolean while_loop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "while_loop")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, WHILE_LOOP, "<while loop>");
    r = consumeTokens(b, 0, WHILE, LPAREN);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
