import com.fetchapi.files.FileSaver
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.io.File
import java.io.File.*
import java.lang.System.getProperty

class FileSaverTest {
    private val fileSaver = FileSaver()
    private val exampleContent = """test file content""".trim()
    private val exampleFilePath = "example.json"
    private val projectDirectory = "${getProperty("user.dir")}${separator}results$separator"

    @Test
    fun `SaveStringToFile saves file when provided null directory, file name and content - results should be in the read file`() {
        fileSaver.save(null, "example.json", exampleContent)
        val file = File(exampleFilePath)
        assertTrue(file.exists(), "File wasn't created")
        val textOfFile = file.readText()
        assertTrue(textOfFile == exampleContent, "File content doesn't match to saved file")
    }

    @Test
    fun `SaveStringToFile saves file when provided not null directory, file name and content - results should be in the read file`() {
        fileSaver.save(projectDirectory, "example.json", exampleContent)
        val file = File(projectDirectory, exampleFilePath)
        assertTrue(file.exists(), "File wasn't created")
        val textOfFile = file.readText()
        assertTrue(textOfFile == exampleContent, "File content doesn't match to saved file")
    }
}
