package com.fetchapi.execution

import com.google.gson.JsonArray

class PostsDivider {
    fun dividePosts(jsonArray: JsonArray) = jsonArray.toList()
}
