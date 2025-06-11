// This is a generated file. Not intended for manual editing.
package com.dfsek.terra.codetool.stringcomp.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.dfsek.terra.codetool.stringcomp.StringcompElementType;
import com.dfsek.terra.codetool.stringcomp.StringcompTokenType;
import com.dfsek.terra.codetool.stringcomp.psi.impl.*;

public interface StringcompTypes {

  IElementType ARGS = new StringcompElementType("ARGS");
  IElementType BLOCKSTATE = new StringcompElementType("BLOCKSTATE");
  IElementType STATEDEFS = new StringcompElementType("STATEDEFS");

  IElementType ANY = new StringcompTokenType("ANY");
  IElementType COLON = new StringcompTokenType(":");
  IElementType COMMA = new StringcompTokenType(",");
  IElementType EQ = new StringcompTokenType("=");
  IElementType ID = new StringcompTokenType("ID");
  IElementType LBRACK = new StringcompTokenType("[");
  IElementType RBRACK = new StringcompTokenType("]");
  IElementType VALUE = new StringcompTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARGS) {
        return new StringcompArgsImpl(node);
      }
      else if (type == BLOCKSTATE) {
        return new StringcompBlockstateImpl(node);
      }
      else if (type == STATEDEFS) {
        return new StringcompStatedefsImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
