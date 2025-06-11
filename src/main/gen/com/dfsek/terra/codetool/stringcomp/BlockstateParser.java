// This is a generated file. Not intended for manual editing.
package com.dfsek.terra.codetool.stringcomp;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.dfsek.terra.codetool.stringcomp.psi.StringcompTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class BlockstateParser implements PsiParser, LightPsiParser {

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
    return file(b, l + 1);
  }

  /* ********************************************************** */
  // ID EQ? VALUE? COMMA? args?
  public static boolean args(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "args")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    r = r && args_1(b, l + 1);
    r = r && args_2(b, l + 1);
    r = r && args_3(b, l + 1);
    r = r && args_4(b, l + 1);
    exit_section_(b, m, ARGS, r);
    return r;
  }

  // EQ?
  private static boolean args_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "args_1")) return false;
    consumeToken(b, EQ);
    return true;
  }

  // VALUE?
  private static boolean args_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "args_2")) return false;
    consumeToken(b, VALUE);
    return true;
  }

  // COMMA?
  private static boolean args_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "args_3")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  // args?
  private static boolean args_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "args_4")) return false;
    args(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ID COLON? ID? statedefs?
  public static boolean blockstate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "blockstate")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    r = r && blockstate_1(b, l + 1);
    r = r && blockstate_2(b, l + 1);
    r = r && blockstate_3(b, l + 1);
    exit_section_(b, m, BLOCKSTATE, r);
    return r;
  }

  // COLON?
  private static boolean blockstate_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "blockstate_1")) return false;
    consumeToken(b, COLON);
    return true;
  }

  // ID?
  private static boolean blockstate_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "blockstate_2")) return false;
    consumeToken(b, ID);
    return true;
  }

  // statedefs?
  private static boolean blockstate_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "blockstate_3")) return false;
    statedefs(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // blockstate? ANY*
  static boolean file(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = file_0(b, l + 1);
    r = r && file_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // blockstate?
  private static boolean file_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_0")) return false;
    blockstate(b, l + 1);
    return true;
  }

  // ANY*
  private static boolean file_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, ANY)) break;
      if (!empty_element_parsed_guard_(b, "file_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // LBRACK args? RBRACK?
  public static boolean statedefs(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statedefs")) return false;
    if (!nextTokenIs(b, LBRACK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACK);
    r = r && statedefs_1(b, l + 1);
    r = r && statedefs_2(b, l + 1);
    exit_section_(b, m, STATEDEFS, r);
    return r;
  }

  // args?
  private static boolean statedefs_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statedefs_1")) return false;
    args(b, l + 1);
    return true;
  }

  // RBRACK?
  private static boolean statedefs_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statedefs_2")) return false;
    consumeToken(b, RBRACK);
    return true;
  }

}
