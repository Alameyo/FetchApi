import java.io.File

class FileSaver {
    fun save(directory: String?, path: String, content: String) {
        var dir: File? = null
        if(directory!=null && directory.isNotBlank()) {
            dir = File(directory)
            dir.mkdirs()
        }
        File(dir, path).writeText(content)
    }
}
