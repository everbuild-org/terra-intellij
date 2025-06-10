package org.everbuild.terrascript.stringcomp

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import org.everbuild.terrascript.TerrascriptFileType

class StringcompFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, StringcompLanguage) {
    override fun getFileType(): FileType = StringcompFileType
    override fun toString(): String = "Blockstate File"
}