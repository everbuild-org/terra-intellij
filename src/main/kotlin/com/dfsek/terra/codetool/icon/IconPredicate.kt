package com.dfsek.terra.codetool.icon

import javax.swing.Icon
import org.jetbrains.yaml.psi.YAMLMapping

class IconPredicate(val icon: Icon, val requiredKv: Map<String, String?>) {
    fun matches(mapping: YAMLMapping): Boolean = requiredKv.all { (key, value) ->
        val kv = mapping.getKeyValueByKey(key) ?: return@all false
        return kv.valueText == (value ?: return@all true)
    }
}