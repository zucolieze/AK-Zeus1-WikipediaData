package ayds.zeus1.wikipedia.info

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WikipediaInfoAPI {
    @GET("api.php?action=query&list=search&utf8=&format=json&srlimit=1")
    fun getArticle(@Query("srsearch") artist: String): Call<String>
}