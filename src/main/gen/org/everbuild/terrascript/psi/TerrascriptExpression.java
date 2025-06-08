// This is a generated file. Not intended for manual editing.
package org.everbuild.terrascript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TerrascriptExpression extends PsiElement {

  @NotNull
  List<TerrascriptArgumentList> getArgumentListList();

  @NotNull
  List<TerrascriptExpression> getExpressionList();

  @NotNull
  List<TerrascriptLiteral> getLiteralList();

}
