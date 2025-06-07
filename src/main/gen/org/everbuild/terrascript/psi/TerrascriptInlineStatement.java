// This is a generated file. Not intended for manual editing.
package org.everbuild.terrascript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TerrascriptInlineStatement extends PsiElement {

  @Nullable
  TerrascriptExpression getExpression();

  @Nullable
  TerrascriptIdAssignment getIdAssignment();

  @Nullable
  TerrascriptVariableDeclaration getVariableDeclaration();

}
