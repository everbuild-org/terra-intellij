// This is a generated file. Not intended for manual editing.
package com.dfsek.terra.codetool.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TerrascriptExpression extends PsiElement {

  @NotNull
  List<TerrascriptCallExpression> getCallExpressionList();

  @NotNull
  List<TerrascriptExpression> getExpressionList();

  @NotNull
  List<TerrascriptLiteral> getLiteralList();

  @NotNull
  List<TerrascriptVariableUsage> getVariableUsageList();

}
