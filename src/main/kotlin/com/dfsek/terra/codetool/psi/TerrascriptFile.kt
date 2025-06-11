package com.dfsek.terra.codetool.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import com.dfsek.terra.codetool.TerrascriptFileType
import com.dfsek.terra.codetool.TerrascriptLanguage

class TerrascriptFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, TerrascriptLanguage) {
    override fun getFileType(): FileType = TerrascriptFileType
    override fun toString(): String = "Terrascript File"
}