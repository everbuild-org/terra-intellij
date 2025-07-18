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

public class TerrascriptForLoopImpl extends TerrascriptPsiElementImpl implements TerrascriptForLoop {

  public TerrascriptForLoopImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TerrascriptVisitor visitor) {
    visitor.visitForLoop(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TerrascriptVisitor) accept((TerrascriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public TerrascriptBlock getBlock() {
    return findNotNullChildByClass(TerrascriptBlock.class);
  }

  @Override
  @NotNull
  public List<TerrascriptExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TerrascriptExpression.class);
  }

  @Override
  @Nullable
  public TerrascriptIdAssignment getIdAssignment() {
    return findChildByClass(TerrascriptIdAssignment.class);
  }

  @Override
  @Nullable
  public TerrascriptVariableDeclaration getVariableDeclaration() {
    return findChildByClass(TerrascriptVariableDeclaration.class);
  }

}
