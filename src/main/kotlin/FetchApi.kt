import com.google.gson.JsonObject

private val fetchApiClient = FetchPostsClient()
private val postsDivider = PostsDivider()
private val postValidator = PostValidator()
private val postSaver = PostSaver()

fun main() {
    val posts = fetchApiClient.fetchBlogPosts()
    val listOfPosts = posts.let { postsDivider.dividePosts(it) }
    listOfPosts.forEach { postValidator.validate(it as JsonObject) }
    listOfPosts.forEach { postSaver.save(it as JsonObject) }
}
