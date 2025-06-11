package com.dfsek.terra.codetool.stdlib

import kotlinx.serialization.json.Json

object StandardLibrary {
    val functions: List<FunctionDefinition> by lazy {
        loadFunctions("/stubs/base.json") + loadFunctions("/stubs/seismic.json")
    }

    private val json = Json { ignoreUnknownKeys = true }

    private fun loadFunctions(path: String): List<FunctionDefinition> {
        return try {
            val text = StandardLibrary::class.java.getResource(path)?.readText()
            if (text != null) {
                json.decodeFromString<List<FunctionDefinition>>(text)
            } else {
                emptyList()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}