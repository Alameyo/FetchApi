package com.fetchapi

import com.fetchapi.files.ApplicationProperties
import com.fetchapi.files.PostSaver
import com.fetchapi.http.FetchPostsClient
import com.fetchapi.validation.PostValidator
import com.google.gson.JsonObject
import java.io.File.separator
import java.lang.System.getProperty

private val fetchApiClient = FetchPostsClient()
private val postValidator = PostValidator()
private val postSaver = PostSaver()
private val applicationProperties = ApplicationProperties()
private var directoryToSaveFiles = "${getProperty("user.dir")}${separator}results$separator"
private var fetchDataEndpoint = applicationProperties.getValue("dataEndpoint")

fun main(args: Array<String>) {
    if (args.isNotEmpty()) {
        if (args[0].isNotBlank()) {
            directoryToSaveFiles = args[0]
        }
        if(args[1].isNotBlank()) {
            fetchDataEndpoint = args[1]
        }
    }
    val posts = fetchApiClient.fetchBlogPosts(fetchDataEndpoint).toList()
    posts.forEach { postValidator.validate(it as JsonObject) }
    posts.forEach { postSaver.save(it as JsonObject, directoryToSaveFiles)  }
}
