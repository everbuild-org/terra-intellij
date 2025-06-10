// This is a generated file. Not intended for manual editing.
package org.everbuild.terrascript.stringcomp.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.everbuild.terrascript.stringcomp.psi.StringcompTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.everbuild.terrascript.stringcomp.psi.*;

public class StringcompStatedefsImpl extends ASTWrapperPsiElement implements StringcompStatedefs {

  public StringcompStatedefsImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull StringcompVisitor visitor) {
    visitor.visitStatedefs(this);
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

}
