import com.google.gson.JsonArray
import com.google.gson.JsonParser.parseString
import java.net.URI
import java.net.URI.create

class FetchPostsClient {
    private val genericHttpClient = GenericHttpClient()
    private val jsonPlacehorderUri = create("https://jsonplaceholder.typicode.com/posts")

    fun fetchBlogPosts(uri: URI = jsonPlacehorderUri ) = genericHttpClient.httpGet(uri)?.body()?.toJsonArray() ?: JsonArray()

    private fun String.toJsonArray(): JsonArray = parseString(this).asJsonArray
}

