package id.firman.movies.detail

import id.firman.movies.api.MovieApi
import id.firman.movies.api.YoutubeVideoResponse
import id.firman.movies.model.MovieDetail
import rx.Observable

class DetailInteractorImpl(private val movieDbApi: MovieApi): DetailInteractor{
    override fun getMovieVideos(id: String): Observable<YoutubeVideoResponse> {
        return movieDbApi.getMovieVideos(id)
    }

    override fun getMovieDetails(id: String): Observable<MovieDetail> {
        return movieDbApi.getMovieDetails(id, createQueryMap())
    }


    private fun createQueryMap(): Map<String, String>{
        return hashMapOf(
            "language" to "en"
        )
    }
}