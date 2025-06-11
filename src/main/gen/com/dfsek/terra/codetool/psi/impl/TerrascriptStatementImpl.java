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

public class TerrascriptStatementImpl extends TerrascriptPsiElementImpl implements TerrascriptStatement {

  public TerrascriptStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TerrascriptVisitor visitor) {
    visitor.visitStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TerrascriptVisitor) accept((TerrascriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public TerrascriptConditional getConditional() {
    return findChildByClass(TerrascriptConditional.class);
  }

  @Override
  @Nullable
  public TerrascriptControlFlowStatement getControlFlowStatement() {
    return findChildByClass(TerrascriptControlFlowStatement.class);
  }

  @Override
  @Nullable
  public TerrascriptExpressionStatement getExpressionStatement() {
    return findChildByClass(TerrascriptExpressionStatement.class);
  }

  @Override
  @Nullable
  public TerrascriptForLoop getForLoop() {
    return findChildByClass(TerrascriptForLoop.class);
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

  @Override
  @Nullable
  public TerrascriptWhileLoop getWhileLoop() {
    return findChildByClass(TerrascriptWhileLoop.class);
  }

  @Override
  @Nullable
  public PsiElement getComment() {
    return findChildByType(COMMENT);
  }

}
