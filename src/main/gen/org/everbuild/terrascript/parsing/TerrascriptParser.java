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
  // multiplicative_expression ((PLUS | MINUS) multiplicative_expression)*
  static boolean additive_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additive_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = multiplicative_expression(b, l + 1);
    r = r && additive_expression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ((PLUS | MINUS) multiplicative_expression)*
  private static boolean additive_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additive_expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!additive_expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "additive_expression_1", c)) break;
    }
    return true;
  }

  // (PLUS | MINUS) multiplicative_expression
  private static boolean additive_expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additive_expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = additive_expression_1_0_0(b, l + 1);
    r = r && multiplicative_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // PLUS | MINUS
  private static boolean additive_expression_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additive_expression_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    return r;
  }

  /* ********************************************************** */
  // expression (COMMA expression)*
  public static boolean argument_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENT_LIST, "<argument list>");
    r = expression(b, l + 1);
    r = r && argument_list_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA expression)*
  private static boolean argument_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!argument_list_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "argument_list_1", c)) break;
    }
    return true;
  }

  // COMMA expression
  private static boolean argument_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expression(b, l + 1);
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
  // (LBRACE statement* RBRACE) | statement
  public static boolean block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BLOCK, "<block>");
    r = block_0(b, l + 1);
    if (!r) r = statement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LBRACE statement* RBRACE
  private static boolean block_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && block_0_1(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // statement*
  private static boolean block_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "block_0_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ID LPAREN argument_list? RPAREN
  public static boolean call_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CALL_EXPRESSION, "<call expression>");
    r = consumeTokens(b, 0, ID, LPAREN);
    r = r && call_expression_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // argument_list?
  private static boolean call_expression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_expression_2")) return false;
    argument_list(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // call_expression | primary_expression
  static boolean call_or_primary_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_or_primary_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = call_expression(b, l + 1);
    if (!r) r = primary_expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // if_statement (ELSE if_statement)* else_block?
  public static boolean conditional(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONDITIONAL, "<conditional>");
    r = if_statement(b, l + 1);
    r = r && conditional_1(b, l + 1);
    r = r && conditional_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (ELSE if_statement)*
  private static boolean conditional_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!conditional_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "conditional_1", c)) break;
    }
    return true;
  }

  // ELSE if_statement
  private static boolean conditional_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && if_statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // else_block?
  private static boolean conditional_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional_2")) return false;
    else_block(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (RETURN | FAIL | BREAK | CONTINUE) SEMICOLON
  public static boolean control_flow_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "control_flow_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONTROL_FLOW_STATEMENT, "<control flow statement>");
    r = control_flow_statement_0(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // RETURN | FAIL | BREAK | CONTINUE
  private static boolean control_flow_statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "control_flow_statement_0")) return false;
    boolean r;
    r = consumeToken(b, RETURN);
    if (!r) r = consumeToken(b, FAIL);
    if (!r) r = consumeToken(b, BREAK);
    if (!r) r = consumeToken(b, CONTINUE);
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
  // relational_expression ((EQEQ | NEQ) relational_expression)*
  static boolean equality_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equality_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = relational_expression(b, l + 1);
    r = r && equality_expression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ((EQEQ | NEQ) relational_expression)*
  private static boolean equality_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equality_expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!equality_expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "equality_expression_1", c)) break;
    }
    return true;
  }

  // (EQEQ | NEQ) relational_expression
  private static boolean equality_expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equality_expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = equality_expression_1_0_0(b, l + 1);
    r = r && relational_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // EQEQ | NEQ
  private static boolean equality_expression_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equality_expression_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, EQEQ);
    if (!r) r = consumeToken(b, NEQ);
    return r;
  }

  /* ********************************************************** */
  // logical_or_expression
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, EXPRESSION, "<expression>");
    r = logical_or_expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // expression SEMICOLON
  public static boolean expression_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION_STATEMENT, "<expression statement>");
    r = expression(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // variable_declaration | expression
  static boolean for_initializer(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_initializer")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = variable_declaration(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // FOR LPAREN for_initializer? SEMICOLON expression? SEMICOLON for_update? RPAREN block
  public static boolean for_loop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_loop")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FOR_LOOP, "<for loop>");
    r = consumeTokens(b, 0, FOR, LPAREN);
    r = r && for_loop_2(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    r = r && for_loop_4(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    r = r && for_loop_6(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // for_initializer?
  private static boolean for_loop_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_loop_2")) return false;
    for_initializer(b, l + 1);
    return true;
  }

  // expression?
  private static boolean for_loop_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_loop_4")) return false;
    expression(b, l + 1);
    return true;
  }

  // for_update?
  private static boolean for_loop_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_loop_6")) return false;
    for_update(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // id_assignment | expression
  static boolean for_update(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_update")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = id_assignment(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // variable_usage EQ expression
  public static boolean id_assignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id_assignment")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ID_ASSIGNMENT, "<id assignment>");
    r = variable_usage(b, l + 1);
    r = r && consumeToken(b, EQ);
    p = r; // pin = 2
    r = r && expression(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // IF LPAREN expression RPAREN block
  public static boolean if_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IF_STATEMENT, "<if statement>");
    r = consumeTokens(b, 0, IF, LPAREN);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && block(b, l + 1);
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
  // equality_expression (L_AND equality_expression)*
  static boolean logical_and_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_and_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = equality_expression(b, l + 1);
    r = r && logical_and_expression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (L_AND equality_expression)*
  private static boolean logical_and_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_and_expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!logical_and_expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "logical_and_expression_1", c)) break;
    }
    return true;
  }

  // L_AND equality_expression
  private static boolean logical_and_expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_and_expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_AND);
    r = r && equality_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // logical_and_expression (L_OR logical_and_expression)*
  static boolean logical_or_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_or_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = logical_and_expression(b, l + 1);
    r = r && logical_or_expression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (L_OR logical_and_expression)*
  private static boolean logical_or_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_or_expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!logical_or_expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "logical_or_expression_1", c)) break;
    }
    return true;
  }

  // L_OR logical_and_expression
  private static boolean logical_or_expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_or_expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_OR);
    r = r && logical_and_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // unary_expression ((MUL | DIV | MOD) unary_expression)*
  static boolean multiplicative_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicative_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = unary_expression(b, l + 1);
    r = r && multiplicative_expression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ((MUL | DIV | MOD) unary_expression)*
  private static boolean multiplicative_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicative_expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!multiplicative_expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "multiplicative_expression_1", c)) break;
    }
    return true;
  }

  // (MUL | DIV | MOD) unary_expression
  private static boolean multiplicative_expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicative_expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = multiplicative_expression_1_0_0(b, l + 1);
    r = r && unary_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // MUL | DIV | MOD
  private static boolean multiplicative_expression_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicative_expression_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, MUL);
    if (!r) r = consumeToken(b, DIV);
    if (!r) r = consumeToken(b, MOD);
    return r;
  }

  /* ********************************************************** */
  // literal | variable_usage | LPAREN expression RPAREN
  static boolean primary_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = literal(b, l + 1);
    if (!r) r = variable_usage(b, l + 1);
    if (!r) r = primary_expression_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
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

  /* ********************************************************** */
  // additive_expression ((LT | GT | LE | GE) additive_expression)*
  static boolean relational_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relational_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = additive_expression(b, l + 1);
    r = r && relational_expression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ((LT | GT | LE | GE) additive_expression)*
  private static boolean relational_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relational_expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!relational_expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "relational_expression_1", c)) break;
    }
    return true;
  }

  // (LT | GT | LE | GE) additive_expression
  private static boolean relational_expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relational_expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = relational_expression_1_0_0(b, l + 1);
    r = r && additive_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LT | GT | LE | GE
  private static boolean relational_expression_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relational_expression_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, LT);
    if (!r) r = consumeToken(b, GT);
    if (!r) r = consumeToken(b, LE);
    if (!r) r = consumeToken(b, GE);
    return r;
  }

  /* ********************************************************** */
  // variable_declaration SEMICOLON
  //     | id_assignment SEMICOLON
  //     | expression_statement
  //     | conditional
  //     | while_loop
  //     | for_loop
  //     | control_flow_statement
  //     | COMMENT
  //     | SEMICOLON
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = statement_0(b, l + 1);
    if (!r) r = statement_1(b, l + 1);
    if (!r) r = expression_statement(b, l + 1);
    if (!r) r = conditional(b, l + 1);
    if (!r) r = while_loop(b, l + 1);
    if (!r) r = for_loop(b, l + 1);
    if (!r) r = control_flow_statement(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // variable_declaration SEMICOLON
  private static boolean statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = variable_declaration(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // id_assignment SEMICOLON
  private static boolean statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = id_assignment(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !(LBRACE | RBRACE | SEMICOLON)
  static boolean statement_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !statement_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LBRACE | RBRACE | SEMICOLON
  private static boolean statement_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_recover_0")) return false;
    boolean r;
    r = consumeToken(b, LBRACE);
    if (!r) r = consumeToken(b, RBRACE);
    if (!r) r = consumeToken(b, SEMICOLON);
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
  // (MINUS | L_NOT) unary_expression | call_or_primary_expression
  static boolean unary_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = unary_expression_0(b, l + 1);
    if (!r) r = call_or_primary_expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (MINUS | L_NOT) unary_expression
  private static boolean unary_expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_expression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = unary_expression_0_0(b, l + 1);
    r = r && unary_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // MINUS | L_NOT
  private static boolean unary_expression_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_expression_0_0")) return false;
    boolean r;
    r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, L_NOT);
    return r;
  }

  /* ********************************************************** */
  // vartype ID assignment?
  public static boolean variable_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_declaration")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_DECLARATION, "<variable declaration>");
    r = vartype(b, l + 1);
    r = r && consumeToken(b, ID);
    p = r; // pin = 2
    r = r && variable_declaration_2(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // assignment?
  private static boolean variable_declaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_declaration_2")) return false;
    assignment(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ID
  public static boolean variable_usage(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_usage")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_USAGE, "<variable usage>");
    r = consumeToken(b, ID);
    exit_section_(b, l, m, r, false, null);
    return r;
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
