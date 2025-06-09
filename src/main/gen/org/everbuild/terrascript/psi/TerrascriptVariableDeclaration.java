// This is a generated file. Not intended for manual editing.
package org.everbuild.terrascript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TerrascriptVariableDeclaration extends TerrascriptNamedElement {

  @Nullable
  TerrascriptAssignment getAssignment();

  @NotNull
  TerrascriptVartype getVartype();

  @NotNull
  PsiElement getId();

  String getName();

  TerrascriptVariableDeclaration setName(String newName);

  PsiElement getNameIdentifier();

}
