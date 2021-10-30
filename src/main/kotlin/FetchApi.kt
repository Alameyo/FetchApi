import com.google.gson.JsonObject
import java.io.File.separator
import java.lang.System.getProperty

private val fetchApiClient = FetchPostsClient()
private val postsDivider = PostsDivider()
private val postValidator = PostValidator()
private val postSaver = PostSaver()
private var directoryToSaveFiles = "${getProperty("user.dir")}${separator}results$separator"

fun main(args: Array<String>) {
    if(args.isNotEmpty() && args[0].isNotBlank()) {
        directoryToSaveFiles = args[0]
    }
    val posts = fetchApiClient.fetchBlogPosts()
    val listOfPosts = posts.let { postsDivider.dividePosts(it) }
    listOfPosts.forEach { postValidator.validate(it as JsonObject) }
    listOfPosts.forEach { postSaver.save(it as JsonObject, directoryToSaveFiles)  }
}
