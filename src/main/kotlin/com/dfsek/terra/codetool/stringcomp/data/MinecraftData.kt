package com.dfsek.terra.codetool.stringcomp.data

import kotlinx.serialization.json.Json

object MinecraftData {
    val states: Map<String, BlockData>
    val blocks get() = states.keys.toList()

    private val json = Json { ignoreUnknownKeys = true }
    init {
        states = try {
            val text = MinecraftData::class.java.getResource("/registryData/blocks.json")?.readText()
            if (text != null) {
                json.decodeFromString<Map<String, BlockData>>(text)
            } else {
                emptyMap()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            emptyMap()
        }.mapKeys { it.key.replace("minecraft:", "") }
    }
}