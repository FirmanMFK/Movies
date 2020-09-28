package id.firman.movies.movie.upcoming

import id.firman.movies.model.Movie

interface UpcomingView {
    fun showUpcomingMovies(movies : List<Movie>?)
}