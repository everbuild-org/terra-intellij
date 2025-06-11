package com.dfsek.terra.codetool.psi

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory
import com.dfsek.terra.codetool.TerrascriptFileType

object TerrascriptPsiFactory {
    fun createIdentifier(project: Project, name: String): PsiElement {
        val text = "num $name;"
        val file = createFile(project, text)
        return (file.firstChild as TerrascriptStatement)
            .variableDeclaration!!
            .id
    }

    private fun createFile(project: Project, text: String): TerrascriptFile {
        return PsiFileFactory.getInstance(project)
            .createFileFromText("dummy.tesf", TerrascriptFileType, text) as TerrascriptFile
    }

    fun createLiteral(project: Project, s: String): TerrascriptLiteral {
        val text = "\"$s\";"
        val file = createFile(project, text)
        return (file.firstChild as TerrascriptStatement).expressionStatement!!.expression.literalList[0]
    }
}