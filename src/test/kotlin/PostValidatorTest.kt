import com.google.gson.JsonParser.parseString
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class PostValidatorTest {
    private val postValidator = PostValidator()

    @Suppress("MaxLineLength")
    private val correctPost =
        parseString("""{"userId":1,"id":2,"title":"qui est esse","body":"est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui aperiam non debitis possimus qui neque nisi nulla"}"""
            .trim()).asJsonObject

    @Suppress("MaxLineLength")
    private val tooMuchFieldsPost =
        parseString("""{"additionalField":0,"userId":1,"id":2,"title":"qui est esse","body":"est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui aperiam non debitis possimus qui neque nisi nulla"}"""
            .trim()).asJsonObject

    @Suppress("MaxLineLength")
    private val postWithoutBody =
        parseString("""{"userId":1,"id":2,"title":"qui est esse"}"""
            .trim()).asJsonObject

    @Suppress("MaxLineLength")
    private val negativeUserIdPost =
        parseString("""{"userId":-452,"id":2,"title":"qui est esse","body":"est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui aperiam non debitis possimus qui neque nisi nulla"}"""
            .trim()).asJsonObject

    @Suppress("MaxLineLength")
    private val negativeIdPost =
        parseString("""{"userId":1,"id":-2,"title":"qui est esse","body":"est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui aperiam non debitis possimus qui neque nisi nulla"}"""
            .trim()).asJsonObject

    @Test
    fun `Correct post is validated - should not throw exception`() {
        assertDoesNotThrow {
            postValidator.validate(correctPost)
        }
    }

    @Test
    fun `When there is additional field - should throw exception`() {
        assertThrows(InputValidationException::class.java) {
            postValidator.validate(tooMuchFieldsPost)
        }
    }

    @Test
    fun `When field is missing - should throw exception`() {
        assertThrows(InputValidationException::class.java) {
            postValidator.validate(postWithoutBody)
        }
    }

    @Test
    fun `When user id is negative- should throw exception`() {
        assertThrows(InputValidationException::class.java) {
            postValidator.validate(negativeUserIdPost)
        }
    }

    @Test
    fun `When post id is negative- should throw exception`() {
        assertThrows(InputValidationException::class.java) {
            postValidator.validate(negativeIdPost)
        }
    }
}
