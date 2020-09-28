package id.firman.movies.movie

import id.firman.movies.api.MovieApi
import id.firman.movies.api.MovieResponse
import rx.Observable

class MovieInteractorImpl(private val movieDbApi: MovieApi): MovieInteractor {
    override fun getUpcomingMovies(): Observable<MovieResponse> {
        return movieDbApi.getUpcomingMovie(createQueryMap())
    }

    override fun getPopularMovies(): Observable<MovieResponse> {
        return movieDbApi.getPopularMovie(createQueryMap())
    }

    override fun getNowPlayingMovies(): Observable<MovieResponse> {
        return movieDbApi.getNowPlayingMovie(createQueryMap())
    }

    private fun createQueryMap(): Map<String, String>{
        return hashMapOf(
            "language" to "en",
            "sort_by" to "popularity.desc"
        )
    }
}