package org.everbuild.terrascript.docs

import com.intellij.lang.parameterInfo.CreateParameterInfoContext
import com.intellij.lang.parameterInfo.ParameterInfoHandler
import com.intellij.lang.parameterInfo.ParameterInfoUIContext
import com.intellij.lang.parameterInfo.UpdateParameterInfoContext
import com.intellij.psi.PsiFile
import com.intellij.psi.util.PsiTreeUtil
import org.everbuild.terrascript.psi.TerrascriptArgumentList
import org.everbuild.terrascript.psi.TerrascriptCallExpression
import org.everbuild.terrascript.stdlib.Argument
import org.everbuild.terrascript.stdlib.StandardLibrary

class TerrascriptParameterInfoHandler : ParameterInfoHandler<TerrascriptCallExpression, Argument> {
    override fun findElementForParameterInfo(context: CreateParameterInfoContext): TerrascriptCallExpression? {
        return findCallExpression(context.file, context.offset)
    }

    override fun showParameterInfo(element: TerrascriptCallExpression, context: CreateParameterInfoContext) {
        val functionName = element.id.text
        val function = StandardLibrary.functions.find { it.name == functionName }
        if (function != null && function.arguments.isNotEmpty()) {
            context.itemsToShow = function.arguments.toTypedArray()
            context.showHint(element, element.textRange.startOffset, this)
        }
    }

    override fun findElementForUpdatingParameterInfo(context: UpdateParameterInfoContext): TerrascriptCallExpression? {
        return findCallExpression(context.file, context.offset)
    }

    override fun updateParameterInfo(parameterOwner: TerrascriptCallExpression, context: UpdateParameterInfoContext) {
        val argumentList = parameterOwner.argumentList ?: return
        val currentParameterIndex = findCurrentParameterIndex(argumentList, context.offset)
        context.setCurrentParameter(currentParameterIndex)
    }

    override fun updateUI(p: Argument, context: ParameterInfoUIContext) {
        if (context.isUIComponentEnabled) {
            val sb = StringBuilder()
            sb.append(p.name).append(": ").append(p.type)

            val startOffset = 0
            val endOffset = sb.length

            context.setupUIComponentPresentation(
                sb.toString(),
                startOffset,
                endOffset,
                false,
                false,
                false,
                context.defaultParameterColor
            )
        }
    }

    private fun findCallExpression(file: PsiFile, offset: Int): TerrascriptCallExpression? {
        val element = file.findElementAt(offset)
        return PsiTreeUtil.getParentOfType(element, TerrascriptCallExpression::class.java)
    }

    private fun findCurrentParameterIndex(argList: TerrascriptArgumentList, offset: Int): Int {
        return argList.expressionList.takeWhile { it.textRange.endOffset < offset }.size
    }
}