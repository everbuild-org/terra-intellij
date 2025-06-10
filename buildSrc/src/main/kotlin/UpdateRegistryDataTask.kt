@file:Suppress("ObjectLiteralToLambda") // "Unique" errors happen if we use lambdas here.

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import java.net.URI
import javax.inject.Inject
import org.gradle.api.Action
import org.gradle.api.file.CopySpec
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.file.FileSystemOperations
import org.gradle.api.file.RegularFile
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.Property
import org.gradle.process.ExecOperations
import org.gradle.process.JavaExecSpec

abstract class UpdateRegistryDataTask @Inject constructor(
    private val execOperations: ExecOperations,
    private val fileSystemOperations: FileSystemOperations
) : DefaultTask() {

    @get:org.gradle.api.tasks.Input
    abstract val mcVersion: Property<String>

    @get:org.gradle.api.tasks.Input
    abstract val serverJarUrl: Property<String>

    @get:org.gradle.api.tasks.Input
    abstract val interestingReports: ListProperty<String>

    @get:org.gradle.api.tasks.OutputDirectory
    abstract val outputResourcesDir: DirectoryProperty

    private val cacheDir = project.layout.buildDirectory.dir("minecraftCache")
    private val generatedDir = cacheDir.get().dir("generated")
    private val reportsDir = generatedDir.dir("reports")
    private val layout = project.layout

    init {
        group = "Minecraft Data"
        description = "Downloads, generates, and copies all necessary Minecraft registry data."

        interestingReports.convention(listOf("blocks.json"))
        outputResourcesDir.convention(project.layout.projectDirectory.dir("src/main/resources/registryData"))
    }

    @TaskAction
    fun execute() {
        val serverJar = cacheDir.get().file("server-${mcVersion.get()}.jar")
        downloadServerJar(serverJar)
        generateRegistryData(serverJar)
        copyRegistryData()
        logger.quiet("Minecraft registry data is up to date.")
    }

    private fun downloadServerJar(serverJar: RegularFile) {
        val serverJarFile = serverJar.asFile
        if (!serverJarFile.exists()) {
            logger.quiet("Server JAR not found. Downloading Minecraft ${mcVersion.get()} server...")
            cacheDir.get().asFile.mkdirs()
            URI(serverJarUrl.get()).toURL().openStream().use { input ->
                serverJarFile.outputStream().use { output ->
                    input.copyTo(output)
                }
            }
            logger.quiet("Download complete.")
        } else {
            logger.quiet("Server JAR is already cached.")
        }
    }

    private fun generateRegistryData(serverJar: RegularFile) {
        val files = layout.files(serverJar.asFile)
        if (!generatedDir.asFile.exists()) {
            logger.quiet("Generated data not found. Running data generator...")
            execOperations.javaexec(object : Action<JavaExecSpec> {
                override fun execute(t: JavaExecSpec) {
                    t.classpath = files
                    t.jvmArgs = listOf("-DbundlerMainClass=net.minecraft.data.Main")
                    t.args = listOf("--reports", "--output", generatedDir.asFile.absolutePath)
                    t.workingDir = cacheDir.get().asFile
                }
            })
            logger.quiet("Data generation complete.")
        } else {
            logger.quiet("Data generator has already been run.")
        }
    }

    private fun copyRegistryData() {
        logger.quiet("Copying reports to ${outputResourcesDir.get().asFile.path}...")
        fileSystemOperations.copy(object : Action<CopySpec> {
            override fun execute(t: CopySpec) {
                t.from(reportsDir, object : Action<CopySpec> {
                    override fun execute(t: CopySpec) {
                        t.include(interestingReports.get())
                    }
                })
                t.into(outputResourcesDir.get().asFile)
            }
        })
        logger.quiet("Copied ${interestingReports.get().size} reports.")
    }
}
