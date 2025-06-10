package org.everbuild.terrascript.docs

import org.everbuild.terrascript.stdlib.FunctionDefinition
import org.everbuild.terrascript.stdlib.StandardLibrary

object TerrascriptDocumentationGenerator {
    fun generateDocumentation(functionName: String): String? {
        val function = StandardLibrary.functions.find { it.name == functionName }
        return function?.let { generateFunctionDoc(it) }
    }

    private fun generateFunctionDoc(func: FunctionDefinition): String {
        val builder = StringBuilder()
        builder.append("<b>${func.name}</b>")

        val params = func.arguments.joinToString(", ") { "${it.name}: ${it.type}" }
        builder.append("($params) -> ${func.returns}")
        builder.append("<br><br>${func.description}")

        if (func.arguments.isNotEmpty()) {
            builder.append("<br><br><b>Parameters:</b>")
            builder.append("<ul>")
            func.arguments.forEach { arg ->
                builder.append("<li><b>${arg.name}</b> (${arg.type}): ${arg.description}</li>")
            }
            builder.append("</ul>")
        }

        if (!func.returnValues.isNullOrEmpty()) {
            builder.append("<br><b>Possible Return Values:</b>")
            builder.append("<ul>")
            func.returnValues.forEach { value ->
                builder.append("<li><code>${value}</code></li>")
            }
            builder.append("</ul>")
        }

        return builder.toString()
    }
}