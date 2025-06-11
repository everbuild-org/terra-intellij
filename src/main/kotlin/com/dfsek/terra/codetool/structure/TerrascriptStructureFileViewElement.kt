package com.dfsek.terra.codetool.structure

import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.navigation.NavigationItem
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import com.dfsek.terra.codetool.psi.TerrascriptVariableDeclaration

class TerrascriptStructureFileViewElement(private val element: PsiElement) : StructureViewTreeElement, SortableTreeElement {
    override fun getValue(): Any = element

    override fun getPresentation(): ItemPresentation {
        return (element as NavigationItem).presentation
            ?: throw IllegalStateException("PSI Element has no presentation")
    }

    override fun getChildren(): Array<TreeElement> {
        return PsiTreeUtil.findChildrenOfType(element, TerrascriptVariableDeclaration::class.java).map {
            TerrascriptStructureFileVariableDeclarationElement(it)
        }.toTypedArray<TreeElement>()
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
        return (element as? TerrascriptVariableDeclaration)?.id?.text ?: ""
    }
}
