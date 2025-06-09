package org.everbuild.terrascript.psi

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory
import org.everbuild.terrascript.TerrascriptFileType

class TerrascriptPsiFactory(private val project: Project) {
    fun createIdentifier(name: String): PsiElement {
        val text = "num $name;"
        val file = createFile(text)
        return (file.firstChild as TerrascriptStatement)
            .variableDeclaration!!
            .idToken
    }

    private fun createFile(text: String): TerrascriptFile {
        return PsiFileFactory.getInstance(project)
            .createFileFromText("dummy.tesf", TerrascriptFileType, text) as TerrascriptFile
    }
}