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

public class TerrascriptExpressionStatementImpl extends TerrascriptPsiElementImpl implements TerrascriptExpressionStatement {

  public TerrascriptExpressionStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TerrascriptVisitor visitor) {
    visitor.visitExpressionStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TerrascriptVisitor) accept((TerrascriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public TerrascriptExpression getExpression() {
    return findNotNullChildByClass(TerrascriptExpression.class);
  }

}
