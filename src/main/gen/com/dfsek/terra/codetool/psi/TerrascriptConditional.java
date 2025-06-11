// This is a generated file. Not intended for manual editing.
package com.dfsek.terra.codetool.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TerrascriptConditional extends PsiElement {

  @Nullable
  TerrascriptElseBlock getElseBlock();

  @NotNull
  List<TerrascriptIfStatement> getIfStatementList();

}
