package com.dfsek.terra.codetool.action

import com.intellij.ide.actions.CreateFileFromTemplateAction
import com.intellij.ide.actions.CreateFileFromTemplateDialog
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.NlsContexts
import com.intellij.psi.PsiDirectory
import com.dfsek.terra.codetool.TerrascriptFileType
import org.jetbrains.annotations.NonNls

class CreateNewTesfFile : CreateFileFromTemplateAction() {
    override fun buildDialog(
        project: Project,
        directory: PsiDirectory,
        builder: CreateFileFromTemplateDialog.Builder
    ) {
        builder.setTitle("Create New Terra Script File")
        builder.addKind("Pling", TerrascriptFileType.icon, "main")
    }

    override fun getActionName(
        directory: PsiDirectory?,
        newName: @NonNls String,
        templateName: @NonNls String?
    ): @NlsContexts.Command String? = "Terrascript"
}