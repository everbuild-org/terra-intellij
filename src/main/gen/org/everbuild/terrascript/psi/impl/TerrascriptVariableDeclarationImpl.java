// This is a generated file. Not intended for manual editing.
package org.everbuild.terrascript.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.everbuild.terrascript.psi.TesfTypes.*;
import org.everbuild.terrascript.psi.TerrascriptNamedElementImpl;
import org.everbuild.terrascript.psi.*;

public class TerrascriptVariableDeclarationImpl extends TerrascriptNamedElementImpl implements TerrascriptVariableDeclaration {

  public TerrascriptVariableDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TerrascriptVisitor visitor) {
    visitor.visitVariableDeclaration(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TerrascriptVisitor) accept((TerrascriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public TerrascriptAssignment getAssignment() {
    return findChildByClass(TerrascriptAssignment.class);
  }

  @Override
  @NotNull
  public TerrascriptVartype getVartype() {
    return findNotNullChildByClass(TerrascriptVartype.class);
  }

  @Override
  @NotNull
  public PsiElement getId() {
    return findNotNullChildByType(ID);
  }

  @Override
  public @Nullable String getName() {
    return TerrascriptPsiUtil.getName(this);
  }

  @Override
  public @NotNull TerrascriptVariableDeclaration setName(@NotNull String newName) {
    return TerrascriptPsiUtil.setName(this, newName);
  }

  @Override
  public @NotNull PsiElement getNameIdentifier() {
    return TerrascriptPsiUtil.getNameIdentifier(this);
  }

}
