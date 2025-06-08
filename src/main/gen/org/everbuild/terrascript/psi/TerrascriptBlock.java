// This is a generated file. Not intended for manual editing.
package org.everbuild.terrascript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TerrascriptBlock extends PsiElement {

  @NotNull
  List<TerrascriptBlock> getBlockList();

  @NotNull
  List<TerrascriptConditional> getConditionalList();

  @NotNull
  List<TerrascriptControlFlowStatement> getControlFlowStatementList();

  @NotNull
  List<TerrascriptExpression> getExpressionList();

  @NotNull
  List<TerrascriptForLoop> getForLoopList();

  @NotNull
  List<TerrascriptIdAssignment> getIdAssignmentList();

  @NotNull
  List<TerrascriptVariableDeclaration> getVariableDeclarationList();

  @NotNull
  List<TerrascriptWhileLoop> getWhileLoopList();

}
