// This is a generated file. Not intended for manual editing.
package org.everbuild.terrascript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TerrascriptPrimaryExpression extends PsiElement {

  @Nullable
  TerrascriptArgumentList getArgumentList();

  @Nullable
  TerrascriptExpression getExpression();

  @Nullable
  TerrascriptLiteral getLiteral();

  @Nullable
  TerrascriptPrimaryExpression getPrimaryExpression();

  @Nullable
  TerrascriptUnary getUnary();

  @Nullable
  PsiElement getId();

}
