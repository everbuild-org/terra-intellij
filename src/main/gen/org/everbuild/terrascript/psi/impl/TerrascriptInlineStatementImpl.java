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

public class TerrascriptInlineStatementImpl extends ASTWrapperPsiElement implements TerrascriptInlineStatement {

  public TerrascriptInlineStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TerrascriptVisitor visitor) {
    visitor.visitInlineStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TerrascriptVisitor) accept((TerrascriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public TerrascriptExpression getExpression() {
    return findChildByClass(TerrascriptExpression.class);
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
