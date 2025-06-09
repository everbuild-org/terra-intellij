package org.everbuild.terrascript.structure

import com.intellij.ide.util.treeView.smartTree.Sorter
import com.intellij.ide.structureView.StructureViewModel
import com.intellij.ide.structureView.StructureViewModelBase
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.psi.PsiFile
import org.everbuild.terrascript.psi.impl.TerrascriptVariableDeclarationImpl

class TerrascriptStructureViewModel(psiFile: PsiFile) :
    StructureViewModelBase(psiFile, TerrascriptStructureFileViewElement(psiFile)),
    StructureViewModel.ElementInfoProvider {

    override fun getSorters(): Array<Sorter> = arrayOf(Sorter.ALPHA_SORTER)

    override fun isAlwaysShowsPlus(element: StructureViewTreeElement): Boolean = false

    override fun isAlwaysLeaf(element: StructureViewTreeElement): Boolean = false

    override fun getSuitableClasses(): Array<Class<out Any>> {
        return arrayOf(TerrascriptVariableDeclarationImpl::class.java)
    }
}
