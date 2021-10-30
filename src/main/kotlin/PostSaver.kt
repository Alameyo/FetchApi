import com.google.gson.JsonObject

class PostSaver {
    private val fileSaver = FileSaver()
    private fun createFileName(jsonElement: JsonObject): String {
        val id = jsonElement.get("id").asLong
        return "$id.json"
    }

    fun save(jsonObject: JsonObject, directory: String? = null) {
        val fileName = createFileName(jsonObject)
        fileSaver.save(directory, fileName, jsonObject.toString())
    }
}
