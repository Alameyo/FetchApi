import com.google.gson.JsonObject
import java.lang.Exception

class PostSaver {
    private val fileSaver = FileSaver()
    private fun createPath(pathPrefix: String, jsonElement: JsonObject): String {
        val path: String

        val id = jsonElement.get("id").asString
        when {
            id.isNotBlank() -> path = "$pathPrefix$id.json"
            else -> throw Exception("No id in the post")
        }
        return path
    }

    fun save(jsonObject: JsonObject, pathPrefix: String = "") {
        val path = createPath(pathPrefix,jsonObject)
        fileSaver.save(path, jsonObject.toString())
    }
}