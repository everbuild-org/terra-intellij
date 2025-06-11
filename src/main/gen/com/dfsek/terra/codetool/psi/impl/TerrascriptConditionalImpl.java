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

public class TerrascriptConditionalImpl extends TerrascriptPsiElementImpl implements TerrascriptConditional {

  public TerrascriptConditionalImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TerrascriptVisitor visitor) {
    visitor.visitConditional(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TerrascriptVisitor) accept((TerrascriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public TerrascriptElseBlock getElseBlock() {
    return findChildByClass(TerrascriptElseBlock.class);
  }

  @Override
  @NotNull
  public List<TerrascriptIfStatement> getIfStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TerrascriptIfStatement.class);
  }

}
