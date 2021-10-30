package com.fetchapi.files

import java.util.*

fun main() {
    val endpoint = ApplicationProperties().getValue("dataEndpoint")
    println(endpoint)
}

class ApplicationProperties {
    private val inputStream = this::class.java.getResourceAsStream("/app.properties")
    private val properties = Properties().apply {
        load(inputStream)
    }

    fun getValue(propertyName:String) = properties[propertyName] as String
}