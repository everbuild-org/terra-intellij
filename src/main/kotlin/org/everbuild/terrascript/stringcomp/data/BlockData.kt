package org.everbuild.terrascript.stringcomp.data

import kotlinx.serialization.Serializable

@Serializable
data class BlockData(
    val properties: Map<String, List<String>> = emptyMap()
)
