package id.firman.movies.detail

import id.firman.movies.model.MovieDetail
import id.firman.movies.model.YoutubeVideo

interface DetailView {
    fun showMovieDetails(movies : MovieDetail?)
    fun getVideos(videos: List<YoutubeVideo>?)
}