import com.google.gson.JsonObject

private val fetchApiClient = FetchPostsClient()
private val postSaver = PostSaver()
private val postsDivider = PostsDivider()

fun main() {
    val posts = fetchApiClient.fetchBlogPosts()
    val listOfPosts = posts.let { postsDivider.dividePosts(it) }
    listOfPosts.forEach {
        postSaver.save(it as JsonObject)
    }
}
