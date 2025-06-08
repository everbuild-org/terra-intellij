package org.everbuild.terrascript.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import org.everbuild.terrascript.TerrascriptFileType
import org.everbuild.terrascript.TerrascriptLanguage

class TerrascriptFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, TerrascriptLanguage) {
    override fun getFileType(): FileType = TerrascriptFileType
    override fun toString(): String = "Terrascript File"
}