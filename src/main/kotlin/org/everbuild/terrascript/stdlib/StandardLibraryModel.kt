package org.everbuild.terrascript.stdlib

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FunctionDefinition(
    val name: String,
    val description: String,
    val arguments: List<Argument>,
    val returns: String,
    @SerialName("return_values") val returnValues: List<String>? = null
)

@Serializable
data class Argument(
    val name: String,
    val type: String,
    val description: String
)
