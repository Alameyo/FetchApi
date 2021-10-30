import com.google.gson.JsonObject

class PostSaver {
    private val fileSaver = FileSaver()
    private fun createPath(pathPrefix: String, jsonElement: JsonObject): String {
        val id = jsonElement.get("id").asLong
        return "$pathPrefix$id.json"
    }

    fun save(jsonObject: JsonObject, pathPrefix: String = "") {
        val path = createPath(pathPrefix,jsonObject)
        fileSaver.save(path, jsonObject.toString())
    }
}
