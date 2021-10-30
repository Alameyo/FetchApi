import com.google.gson.JsonObject
import com.fetchapi.execution.PostsDivider
import com.fetchapi.files.PostSaver
import com.fetchapi.http.FetchPostsClient
import com.fetchapi.validation.PostValidator
import java.io.File.separator
import java.lang.System.getProperty

private val fetchApiClient = FetchPostsClient()
private val postsDivider = PostsDivider()
private val postValidator = PostValidator()
private val postSaver = PostSaver()
private var directoryToSaveFiles = "${getProperty("user.dir")}${separator}results$separator"
private var fetchDataEndpoint = "https://jsonplaceholder.typicode.com/posts"

fun main(args: Array<String>) {
    if (args.isNotEmpty()) {
        if (args[0].isNotBlank()) {
            directoryToSaveFiles = args[0]
        }
        if(args[1].isNotBlank()) {
            fetchDataEndpoint = args[1]
        }
    }
    val posts = fetchApiClient.fetchBlogPosts(fetchDataEndpoint)
    val listOfPosts = posts.let { postsDivider.dividePosts(it) }
    listOfPosts.forEach { postValidator.validate(it as JsonObject) }
    listOfPosts.forEach { postSaver.save(it as JsonObject, directoryToSaveFiles)  }
}
