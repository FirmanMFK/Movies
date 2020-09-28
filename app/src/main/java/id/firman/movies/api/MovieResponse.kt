package id.firman.movies.api

import com.google.gson.annotations.SerializedName
import id.firman.movies.model.Movie

data class MovieResponse (
    @SerializedName("results")
    var movies: List<Movie>
)