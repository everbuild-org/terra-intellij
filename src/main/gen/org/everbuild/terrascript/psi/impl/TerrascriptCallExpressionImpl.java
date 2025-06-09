// This is a generated file. Not intended for manual editing.
package org.everbuild.terrascript.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.everbuild.terrascript.psi.TesfTypes.*;
import org.everbuild.terrascript.psi.TerrascriptPsiElementImpl;
import org.everbuild.terrascript.psi.*;

public class TerrascriptCallExpressionImpl extends TerrascriptPsiElementImpl implements TerrascriptCallExpression {

  public TerrascriptCallExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TerrascriptVisitor visitor) {
    visitor.visitCallExpression(this);
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
  @NotNull
  public PsiElement getId() {
    return findNotNullChildByType(ID);
  }

}
