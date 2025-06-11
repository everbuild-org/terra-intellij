// This is a generated file. Not intended for manual editing.
package com.dfsek.terra.codetool.stringcomp.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.dfsek.terra.codetool.stringcomp.psi.StringcompTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.dfsek.terra.codetool.stringcomp.psi.*;

public class StringcompArgsImpl extends ASTWrapperPsiElement implements StringcompArgs {

  public StringcompArgsImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull StringcompVisitor visitor) {
    visitor.visitArgs(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof StringcompVisitor) accept((StringcompVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public StringcompArgs getArgs() {
    return findChildByClass(StringcompArgs.class);
  }

  @Override
  @NotNull
  public PsiElement getId() {
    return findNotNullChildByType(ID);
  }

  @Override
  @Nullable
  public PsiElement getValue() {
    return findChildByType(VALUE);
  }

}
