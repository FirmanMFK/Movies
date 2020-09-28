package id.firman.movies.movie.popular

import id.firman.movies.model.Movie

interface PopularView {
    fun showPopularMovies(movies : List<Movie>?)
}