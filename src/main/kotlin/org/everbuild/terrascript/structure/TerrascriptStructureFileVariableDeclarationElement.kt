package org.everbuild.terrascript.structure

import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.navigation.NavigationItem
import com.intellij.psi.PsiElement
import com.intellij.psi.util.childrenOfType
import org.everbuild.terrascript.psi.TerrascriptVariableDeclaration

class TerrascriptStructureFileVariableDeclarationElement(private val element: PsiElement) : StructureViewTreeElement, SortableTreeElement {
    override fun getValue(): Any = element

    override fun getPresentation(): ItemPresentation {
        return (element as NavigationItem).presentation
            ?: throw IllegalStateException("PSI Element has no presentation")
    }

    override fun getChildren(): Array<TreeElement> {
        return TreeElement.EMPTY_ARRAY
    }

    override fun navigate(requestFocus: Boolean) {
        (element as NavigationItem).navigate(requestFocus)
    }

    override fun canNavigate(): Boolean {
        return (element as NavigationItem).canNavigate()
    }

    override fun canNavigateToSource(): Boolean {
        return (element as NavigationItem).canNavigateToSource()
    }

    override fun getAlphaSortKey(): String {
        return (element as? TerrascriptVariableDeclaration)?.idToken?.text ?: ""
    }
}
