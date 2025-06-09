package org.everbuild.terrascript.psi

import com.intellij.icons.AllIcons
import com.intellij.navigation.ItemPresentation
import javax.swing.Icon
import org.everbuild.terrascript.psi.impl.TerrascriptVariableDeclarationImpl

class TerrascriptVariableDeclarationPresentation(private val element: TerrascriptVariableDeclarationImpl) : ItemPresentation {
    override fun getPresentableText(): String? {
        return element.idToken.text
    }

    override fun getLocationString(): String? = null

    override fun getIcon(unused: Boolean): Icon? {
        return AllIcons.Nodes.Variable
    }
}