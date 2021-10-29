import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonObject

class PostsDivider {

    fun dividePosts(jsonArray: JsonArray): List<JsonElement> = jsonArray.toList()
}