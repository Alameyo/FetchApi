import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.io.File

class FileSaverTest {
    private val fileSaver = FileSaver()
    private val exampleContent = """test file content""".trim()
    private val exampleFilePath = "example.json"

    @Test
    fun `SaveStringToFile saves file when provided path and content - results should be in the read file`() {
        fileSaver.save("example.json", exampleContent)
        val file = File(exampleFilePath)
        assertTrue(file.exists(), "File wasn't created")
        val textOfFile = file.readText()
        assertTrue(textOfFile == exampleContent, "File content doesn't match to saved file")
    }
}
