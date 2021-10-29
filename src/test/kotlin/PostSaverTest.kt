import com.google.gson.JsonObject
import com.google.gson.JsonParser.parseString
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.io.File

class PostSaverTest {
    private val postSaver = PostSaver()
    private val examplePostString =
        """{"userId":1,"id":2,"title":"qui est esse","body":"est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui aperiam non debitis possimus qui neque nisi nulla"}""".trim()
    private val examplePost = parseString(examplePostString) as JsonObject
    private val expectedFilePath = "2.json"

    @Test()
    fun `JsonObject - should be saved to file with path and json as file extension for post containing id 2`() {
        postSaver.save(examplePost)
        val file = File(expectedFilePath)
        assertTrue(file.exists(), "File wasn't created")
        val textOfFile = file.readText()
        assertTrue(textOfFile == examplePostString, "File content doesn't match to saved file")
    }
}
