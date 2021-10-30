package com.fetchapi.validation

import com.google.gson.JsonObject

class PostValidator {
    fun validate(post: JsonObject) {
        val userId = post.get("userId")?.asLong
        val id = post.get("id")?.asLong
        val title = post.get("title")?.asString
        val body = post.get("body")?.asString

        when {
            post.size() != 4 -> throw InputValidationException("Incorrect number of elements in post")
            userId == null || userId < 0 -> throw InputValidationException("useId invalid")
            id == null || id < 0 -> throw InputValidationException("id invalid")
            title == null -> throw InputValidationException("Post doesn't have title field")
            body == null -> throw InputValidationException("Post doesn't have body field")
        }
    }
}
