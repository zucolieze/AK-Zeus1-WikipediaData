package ayds.zeus1.wikipedia

import ayds.zeus1.wikipedia.info.WikipediaInfoModule

object WikipediaModule{
    val wikipediaService: WikipediaService = WikipediaInfoModule.WIKIPEDIA_INFO_SERVICE
}