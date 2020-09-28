package id.firman.movies.detail

import id.firman.movies.api.YoutubeVideoResponse
import id.firman.movies.model.MovieDetail
import rx.Observable

interface DetailInteractor {
    fun getMovieDetails(id: String): Observable<MovieDetail>
    fun getMovieVideos(id: String): Observable<YoutubeVideoResponse>
}