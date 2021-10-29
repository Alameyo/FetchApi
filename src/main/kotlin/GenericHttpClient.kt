import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpRequest.newBuilder
import java.net.http.HttpResponse
import java.net.http.HttpResponse.BodyHandlers.ofString

class GenericHttpClient {
    private val httpClient = HttpClient.newHttpClient()

    fun httpGet(addressUri: URI): HttpResponse<String>? {
        val httpRequest = newBuilder().uri(addressUri).build()
        return sendRequest(httpRequest)
    }

    private fun sendRequest(request: HttpRequest) = httpClient.send(request, ofString())

}