import java.io.File

class FileSaver {
    fun save(path: String, content: String) = File(path).writeText(content)
}
