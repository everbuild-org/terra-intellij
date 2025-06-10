package org.everbuild.terrascript.stringcomp

import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.util.NlsContexts
import com.intellij.openapi.util.NlsSafe
import javax.swing.Icon
import org.everbuild.terrascript.TerraIcons
import org.everbuild.terrascript.TerrascriptLanguage
import org.jetbrains.annotations.NonNls

object StringcompFileType : LanguageFileType(StringcompLanguage) {
    override fun getName(): @NonNls String = "terrascript_blockstate"

    override fun getDescription(): @NlsContexts.Label String = "Minecraft blockstate"

    override fun getDefaultExtension(): @NlsSafe String = "minecraft_blockstate"

    override fun getIcon(): Icon? = TerraIcons.TesfFile
}