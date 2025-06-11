package com.dfsek.terra.codetool.icon

import com.dfsek.terra.codetool.TerraIcons
import com.intellij.ide.IconProvider
import com.intellij.openapi.util.Iconable
import com.intellij.psi.PsiElement
import javax.swing.Icon
import org.jetbrains.yaml.YAMLFileType
import org.jetbrains.yaml.psi.YAMLFile
import org.jetbrains.yaml.psi.YAMLMapping

class YamlIconProvider : IconProvider() {
    val predicates = listOf(
        IconPredicate(TerraIcons.BiomeFile, mapOf("type" to "BIOME")),
        IconPredicate(TerraIcons.FeatureFile, mapOf("type" to "FEATURE")),
        IconPredicate(TerraIcons.OreFile, mapOf("type" to "ORE")),
        IconPredicate(TerraIcons.PaletteFile, mapOf("type" to "PALETTE")),
        IconPredicate(TerraIcons.ScatteredOreFile, mapOf("type" to "SCATTERED_ORE")),
        IconPredicate(TerraIcons.PackYmlFile, mapOf("id" to null, "version" to null, "author" to null)),
    )
    
    override fun getIcon(element: PsiElement, @Iconable.IconFlags flags: Int): Icon? {
        if (element !is YAMLFile) return null
        if (element.fileType != YAMLFileType.YML) return null
        if (element.documents.isEmpty()) return null
        val topLevelElement = element.documents[0].topLevelValue
        if (topLevelElement !is YAMLMapping) return null
        return predicates.firstOrNull { it.matches(topLevelElement) }?.icon
    }
}