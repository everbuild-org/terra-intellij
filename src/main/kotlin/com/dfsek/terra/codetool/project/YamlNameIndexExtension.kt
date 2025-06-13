package com.dfsek.terra.codetool.project

import com.intellij.util.indexing.DataIndexer
import com.intellij.util.indexing.DefaultFileTypeSpecificInputFilter
import com.intellij.util.indexing.FileBasedIndex
import com.intellij.util.indexing.FileContent
import com.intellij.util.indexing.ID
import com.intellij.util.indexing.ScalarIndexExtension
import com.intellij.util.io.EnumeratorStringDescriptor
import com.intellij.util.io.KeyDescriptor
import org.jetbrains.yaml.YAMLFileType
import org.jetbrains.yaml.psi.YAMLFile
import org.jetbrains.yaml.psi.YAMLMapping

val NAME_INDEX_NAME = ID.create<String, Void>("com.dfsek.terra.codetool.project.name")

class YamlNameIndexExtension : ScalarIndexExtension<String>() {
    override fun getName(): ID<String, Void> = NAME_INDEX_NAME
    override fun getInputFilter(): FileBasedIndex.InputFilter = DefaultFileTypeSpecificInputFilter(YAMLFileType.YML)
    override fun dependsOnFileContent(): Boolean = true
    
    override fun getIndexer(): DataIndexer<String, Void, FileContent> = YamlNameIndexer
    
    override fun getKeyDescriptor(): KeyDescriptor<String> = EnumeratorStringDescriptor.INSTANCE
    override fun getVersion(): Int = 0
}

private object YamlNameIndexer : DataIndexer<String, Void, FileContent> {
    override fun map(content: FileContent): Map<String, Void?> {
        val psiFile = content.psiFile as? YAMLFile ?: return emptyMap()
        val root = psiFile.documents.firstOrNull()?.topLevelValue as? YAMLMapping? ?: return emptyMap()
        
        val name = root.getKeyValueByKey("id")?.valueText ?: return emptyMap()
        return mapOf(name to null)
    }
}