package com.dfsek.terra.codetool.psi

import com.intellij.icons.AllIcons
import com.intellij.navigation.ItemPresentation
import javax.swing.Icon
import com.dfsek.terra.codetool.psi.impl.TerrascriptVariableDeclarationImpl

class TerrascriptVariableDeclarationPresentation(private val element: TerrascriptVariableDeclarationImpl) : ItemPresentation {
    override fun getPresentableText(): String? {
        return element.id.text
    }

    override fun getLocationString(): String? = null

    override fun getIcon(unused: Boolean): Icon? {
        return AllIcons.Nodes.Variable
    }
}