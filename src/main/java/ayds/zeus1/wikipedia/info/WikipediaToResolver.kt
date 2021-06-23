package ayds.zeus1.wikipedia.info

import ayds.zeus.songinfo.moredetails.model.entities.Article
import com.google.gson.Gson
import com.google.gson.JsonObject

const val ARTIST_SNIPPET = "snippet"
const val ARTIST_URL = "pageid"
private const val SEARCH_JSON = "search"
private const val QUERY_JSON = "query"
private const val WIKIPEDIA_SHORT_URL = "https://en.wikipedia.org/?curid="

interface WikipediaToResolver {
    fun getInfoFromExternalData(body: String?): Article
}

internal class JsonToInfoResolver : WikipediaToResolver {
    override fun getInfoFromExternalData(serviceData: String?): Article =
            serviceData.getFirstItem().getInfoJson().let{ item->
                Article(
                    description = item.getArtistSnippet(),
                    infoUrl = item.getArtistUrl(),
                    sourceLogoUrl = "https://upload.wikimedia.org/wikipedia/commons/8/8c/Wikipedia-logo-v2-es.png"
                )
            }

    private fun String?.getFirstItem(): JsonObject =
        Gson().fromJson(this, JsonObject::class.java)

    private fun JsonObject.getArtistSnippet() = this[ARTIST_SNIPPET].toString()

    private fun JsonObject.getArtistUrl() = WIKIPEDIA_SHORT_URL +this[ARTIST_URL].toString()

    private fun JsonObject.getInfoJson(): JsonObject {
        val query = this[QUERY_JSON].asJsonObject
        return query[SEARCH_JSON].asJsonArray[0].asJsonObject
    }
}