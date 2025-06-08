// This is a generated file. Not intended for manual editing.
package org.everbuild.terrascript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TerrascriptForLoop extends PsiElement {

  @NotNull
  TerrascriptBlock getBlock();

  @NotNull
  List<TerrascriptExpression> getExpressionList();

  @Nullable
  TerrascriptVariableDeclaration getVariableDeclaration();

}
