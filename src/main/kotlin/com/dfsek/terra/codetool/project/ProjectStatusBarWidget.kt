package com.dfsek.terra.codetool.project

import com.dfsek.terra.codetool.TerrascriptFileType
import com.intellij.openapi.application.writeAction
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.fileEditor.FileEditorManagerEvent
import com.intellij.openapi.fileEditor.FileEditorManagerListener
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.wm.StatusBar
import com.intellij.openapi.wm.StatusBarWidget
import com.intellij.psi.search.FileTypeIndex
import com.intellij.util.indexing.events.IndexedFilesListener
import com.intellij.util.messages.MessageBusConnection
import java.awt.Component
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jetbrains.annotations.NonNls
import org.jetbrains.yaml.YAMLFileType

class ProjectStatusBarWidget(val project: Project, val scope: CoroutineScope) : StatusBarWidget, StatusBarWidget.Multiframe {
    private var connection: MessageBusConnection? = null
    private var lastRoot: ProjectRootUtility.ProjectRoot? = null
    override fun ID(): @NonNls String = "terra_project_name"
    
    override fun install(statusBar: StatusBar) {
        connection = project.messageBus.connect()
        connection?.subscribe(FileEditorManagerListener.FILE_EDITOR_MANAGER, object : FileEditorManagerListener {
            override fun fileOpened(source: FileEditorManager, file: VirtualFile) {
                update(statusBar)
            }
            
            override fun fileClosed(source: FileEditorManager, file: VirtualFile) {
                update(statusBar)
            }
            
            override fun selectionChanged(event: FileEditorManagerEvent) {
                update(statusBar)
            }
        })
        connection?.subscribe(
            FileTypeIndex.INDEX_CHANGE_TOPIC,
            FileTypeIndex.IndexChangeListener { fileType ->
                if (fileType == TerrascriptFileType || fileType == YAMLFileType.YML) update(
                    statusBar
                                                                                           )
            })
    }
    
    override fun dispose() {
        connection?.disconnect()
    }
    
    override fun getPresentation(): StatusBarWidget.WidgetPresentation? {
        return object : StatusBarWidget.TextPresentation {
            override fun getText(): String = lastRoot?.id ?: ""
            override fun getAlignment(): Float = Component.CENTER_ALIGNMENT
            override fun getTooltipText(): String? = lastRoot?.addons?.let { formatThreeElementsPlusAmount(it) }
        }
    }
    
    private fun updateContent() {
        val fileEditorManager = FileEditorManager.getInstance(project)
        val currentFile = fileEditorManager.selectedEditor?.file ?: run { lastRoot = null; return }
        lastRoot = ProjectRootUtility.getNearestRoot(currentFile, project)
    }
    
    private fun update(statusBar: StatusBar) = scope.launch {
        withContext(Dispatchers.IO) {
            writeAction { updateContent() }
        }
        statusBar.updateWidget(ID())
    }
    
    override fun copy(): StatusBarWidget = ProjectStatusBarWidget(project, scope)
    
    private fun formatThreeElementsPlusAmount(elements: List<String>): String {
        if (elements.isEmpty()) return "Empty"
        if (elements.size < 4) return elements.joinToString(", ")
        return elements.take(3).joinToString(", ") + ", (+" + (elements.size - 3) + " more)"
    }
}