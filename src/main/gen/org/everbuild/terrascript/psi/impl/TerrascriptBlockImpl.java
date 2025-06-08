// This is a generated file. Not intended for manual editing.
package org.everbuild.terrascript.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.everbuild.terrascript.psi.TesfTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.everbuild.terrascript.psi.*;

public class TerrascriptBlockImpl extends ASTWrapperPsiElement implements TerrascriptBlock {

  public TerrascriptBlockImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TerrascriptVisitor visitor) {
    visitor.visitBlock(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TerrascriptVisitor) accept((TerrascriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<TerrascriptBlock> getBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TerrascriptBlock.class);
  }

  @Override
  @NotNull
  public List<TerrascriptConditional> getConditionalList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TerrascriptConditional.class);
  }

  @Override
  @NotNull
  public List<TerrascriptControlFlowStatement> getControlFlowStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TerrascriptControlFlowStatement.class);
  }

  @Override
  @NotNull
  public List<TerrascriptExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TerrascriptExpression.class);
  }

  @Override
  @NotNull
  public List<TerrascriptForLoop> getForLoopList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TerrascriptForLoop.class);
  }

  @Override
  @NotNull
  public List<TerrascriptIdAssignment> getIdAssignmentList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TerrascriptIdAssignment.class);
  }

  @Override
  @NotNull
  public List<TerrascriptVariableDeclaration> getVariableDeclarationList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TerrascriptVariableDeclaration.class);
  }

  @Override
  @NotNull
  public List<TerrascriptWhileLoop> getWhileLoopList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TerrascriptWhileLoop.class);
  }

}
