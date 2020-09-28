package id.firman.movies.movie.nowplaying

import id.firman.movies.model.Movie

interface NowPlayingView {
    fun showNowPlayingMovies(movies : List<Movie>?)
}