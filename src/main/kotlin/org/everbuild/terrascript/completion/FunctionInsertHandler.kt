package org.everbuild.terrascript.completion

import com.intellij.codeInsight.completion.InsertHandler
import com.intellij.codeInsight.completion.InsertionContext
import com.intellij.codeInsight.lookup.LookupElement

class FunctionInsertHandler(private val hasArgs: Boolean) : InsertHandler<LookupElement> {
    override fun handleInsert(context: InsertionContext, item: LookupElement) {
        val editor = context.editor
        val document = editor.document
        val tailOffset = context.tailOffset

        if (context.file.findElementAt(tailOffset)?.text == "(") {
            return
        }

        if (hasArgs) {
            document.insertString(tailOffset, "()")
            editor.caretModel.moveToOffset(tailOffset + 1)
        } else {
            document.insertString(tailOffset, "();")
            editor.caretModel.moveToOffset(tailOffset + 3)
        }
    }
}