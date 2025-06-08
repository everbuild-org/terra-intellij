package org.everbuild.terrascript

import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.util.NlsContexts
import com.intellij.openapi.util.NlsSafe
import javax.swing.Icon
import org.jetbrains.annotations.NonNls

object TerrascriptFileType : LanguageFileType(TerrascriptLanguage) {
    override fun getName(): @NonNls String = "terrascript"

    override fun getDescription(): @NlsContexts.Label String = "Terra world generation script"

    override fun getDefaultExtension(): @NlsSafe String = "tesf"

    override fun getIcon(): Icon? = TerraIcons.TesfFile
}