package org.everbuild.terrascript.syntax

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import com.intellij.openapi.util.NlsContexts
import javax.swing.Icon
import org.everbuild.terrascript.TerraIcons
import org.jetbrains.annotations.NonNls

class TerrascriptColorSettingsPage : ColorSettingsPage {
    override fun getIcon(): Icon = TerraIcons.TesfFile
    override fun getHighlighter(): SyntaxHighlighter = TerrascriptSyntaxHighlighter()

    override fun getDemoText(): @NonNls String = """
            // A more complex example for syntax highlighting preview.
            num <param>randPrecision</param> = 100;
            num <param>radius</param> = <func_call>randomInt</func_call>(<param>randPrecision</param>)/<param>randPrecision</param>*3 + 1;
            num <param>radiusCeil</param> = <func_call>ceil</func_call>(<param>radius</param>);
            num <param>radiusSquared</param> = <func_call>pow</func_call>(<param>radius</param>, 2);

            <func_call>block</func_call>(0, 0, 0, "minecraft:oak_log");

            for(num x = -<param>radiusCeil</param>; x <= <param>radiusCeil</param>; x = x + 1) {
                for(num y = 0; y <= <param>radiusCeil</param>; y = y + 1) {
                    for(num z = -<param>radiusCeil</param>; z <= <param>radiusCeil</param>; z = z + 1) {
                        num distanceSquared = (<func_call>pow</func_call>(x,2) + <func_call>pow</func_call>(y*3,2) + <func_call>pow</func_call>(z,2));
                        if (distanceSquared/<param>radiusSquared</param> < <func_call>randomInt</func_call>(<param>randPrecision</param>)/<param>randPrecision</param>) {
                            <func_call>block</func_call>(x, y, z, "minecraft:oak_leaves[distance=1,persistent=false]", false);
                        }
                    }
                }
            }
        """.trimIndent()

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey> = mapOf(
        "param" to TerrascriptSyntaxHighlighter.VARIABLE,
        "func_call" to TerrascriptSyntaxHighlighter.FUNCTION
    )

    override fun getAttributeDescriptors(): Array<out AttributesDescriptor> = DESCRIPTORS

    override fun getColorDescriptors(): Array<out ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY

    override fun getDisplayName(): @NlsContexts.ConfigurableName String = "Terrascript"

    companion object {
        private val DESCRIPTORS = arrayOf(
            AttributesDescriptor("Keyword", TerrascriptSyntaxHighlighter.KEYWORD),
            AttributesDescriptor("Variable", TerrascriptSyntaxHighlighter.VARIABLE),
            AttributesDescriptor("Function", TerrascriptSyntaxHighlighter.FUNCTION),
            AttributesDescriptor("String", TerrascriptSyntaxHighlighter.STRING),
            AttributesDescriptor("Number", TerrascriptSyntaxHighlighter.NUMBER),
            AttributesDescriptor("Comment", TerrascriptSyntaxHighlighter.COMMENT),
            AttributesDescriptor("Operator", TerrascriptSyntaxHighlighter.OPERATOR),
            AttributesDescriptor("Semicolon", TerrascriptSyntaxHighlighter.SEMICOLON),
            AttributesDescriptor("Comma", TerrascriptSyntaxHighlighter.COMMA),
            AttributesDescriptor("Parentheses", TerrascriptSyntaxHighlighter.PARENTHESES),
            AttributesDescriptor("Braces", TerrascriptSyntaxHighlighter.BRACES),
            AttributesDescriptor("Bad character", TerrascriptSyntaxHighlighter.BAD_CHARACTER)
        )
    }
}