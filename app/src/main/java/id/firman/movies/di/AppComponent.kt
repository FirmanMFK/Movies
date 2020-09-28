package id.firman.movies.di

import dagger.Component
import id.firman.movies.api.ApiModule
import id.firman.movies.detail.DetailComponent
import id.firman.movies.detail.DetailModule
import id.firman.movies.movie.MovieComponent
import id.firman.movies.movie.MovieModule
import id.firman.movies.network.NetworkModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class), (NetworkModule::class), (ApiModule::class)])
interface AppComponent{
    fun plus(movieModule: MovieModule): MovieComponent
    fun plus(detailModule: DetailModule): DetailComponent
}