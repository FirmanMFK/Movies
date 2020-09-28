package id.firman.movies.movie

import dagger.Subcomponent
import id.firman.movies.di.AppScope
import id.firman.movies.movie.nowplaying.NowPlayingFragment
import id.firman.movies.movie.popular.PopularFragment
import id.firman.movies.movie.upcoming.UpcomingFragment

@AppScope
@Subcomponent(modules = [(MovieModule::class)])
interface MovieComponent {
    fun inject(target: NowPlayingFragment)
    fun inject(target: UpcomingFragment)
    fun inject(target: PopularFragment)
}