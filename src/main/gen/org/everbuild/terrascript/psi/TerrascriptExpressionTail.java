// This is a generated file. Not intended for manual editing.
package org.everbuild.terrascript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TerrascriptExpressionTail extends PsiElement {

  @Nullable
  TerrascriptExpressionTail getExpressionTail();

  @NotNull
  TerrascriptOperator getOperator();

  @NotNull
  TerrascriptPrimaryExpression getPrimaryExpression();

}
