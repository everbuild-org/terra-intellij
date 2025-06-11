package com.dfsek.terra.codetool.stringcomp

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class StringcompFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, StringcompLanguage) {
    override fun getFileType(): FileType = StringcompFileType
    override fun toString(): String = "Blockstate File"
}