package com.fetchapi.http

import com.google.gson.JsonArray
import com.google.gson.JsonParser.parseString
import java.net.URI.create

class FetchPostsClient {
    private val genericHttpClient = GenericHttpClient()

    fun fetchBlogPosts(uri: String) = genericHttpClient.httpGet(create(uri))?.body()?.toJsonArray() ?: JsonArray()

    private fun String.toJsonArray(): JsonArray = parseString(this).asJsonArray
}
