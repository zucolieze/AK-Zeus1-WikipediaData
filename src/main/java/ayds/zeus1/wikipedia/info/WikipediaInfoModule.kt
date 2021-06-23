package ayds.zeus1.wikipedia.info

import ayds.zeus1.wikipedia.WikipediaService
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

object WikipediaInfoModule {

    private const val WIKIPEDIA_URL = "https://en.wikipedia.org/w/"

    private val wikipediaApiRetrofit = Retrofit.Builder()
            .baseUrl(WIKIPEDIA_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()

    private val wikipediaInfoAPI = wikipediaApiRetrofit.create(WikipediaInfoAPI::class.java)

    private val wikipediaToResolver: WikipediaToResolver = JsonToInfoResolver()

    val WIKIPEDIA_INFO_SERVICE: WikipediaService = WikipediaInfoServiceImpl(
            wikipediaInfoAPI,
            wikipediaToResolver
    )
}