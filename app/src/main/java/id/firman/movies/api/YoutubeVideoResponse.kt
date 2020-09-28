package id.firman.movies.api

import com.google.gson.annotations.SerializedName
import id.firman.movies.model.YoutubeVideo

data class YoutubeVideoResponse (
    @SerializedName("results")
    var videos: List<YoutubeVideo>
)