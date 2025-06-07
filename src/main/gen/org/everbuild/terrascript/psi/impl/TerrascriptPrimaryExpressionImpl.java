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

public class TerrascriptPrimaryExpressionImpl extends ASTWrapperPsiElement implements TerrascriptPrimaryExpression {

  public TerrascriptPrimaryExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TerrascriptVisitor visitor) {
    visitor.visitPrimaryExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TerrascriptVisitor) accept((TerrascriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public TerrascriptArgumentList getArgumentList() {
    return findChildByClass(TerrascriptArgumentList.class);
  }

  @Override
  @Nullable
  public TerrascriptExpression getExpression() {
    return findChildByClass(TerrascriptExpression.class);
  }

  @Override
  @Nullable
  public TerrascriptLiteral getLiteral() {
    return findChildByClass(TerrascriptLiteral.class);
  }

  @Override
  @Nullable
  public TerrascriptPrimaryExpression getPrimaryExpression() {
    return findChildByClass(TerrascriptPrimaryExpression.class);
  }

  @Override
  @Nullable
  public TerrascriptUnary getUnary() {
    return findChildByClass(TerrascriptUnary.class);
  }

  @Override
  @Nullable
  public PsiElement getId() {
    return findChildByType(ID);
  }

}
