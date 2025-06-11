// This is a generated file. Not intended for manual editing.
package com.dfsek.terra.codetool.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.dfsek.terra.codetool.psi.TesfTypes.*;
import com.dfsek.terra.codetool.psi.TerrascriptPsiElementImpl;
import com.dfsek.terra.codetool.psi.*;

public class TerrascriptControlFlowStatementImpl extends TerrascriptPsiElementImpl implements TerrascriptControlFlowStatement {

  public TerrascriptControlFlowStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TerrascriptVisitor visitor) {
    visitor.visitControlFlowStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TerrascriptVisitor) accept((TerrascriptVisitor)visitor);
    else super.accept(visitor);
  }

}
