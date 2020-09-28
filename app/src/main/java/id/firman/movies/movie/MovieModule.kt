package id.firman.movies.movie

import dagger.Module
import dagger.Provides
import id.firman.movies.api.MovieApi
import id.firman.movies.di.AppScope
import id.firman.movies.movie.nowplaying.NowPlayingPresenter
import id.firman.movies.movie.nowplaying.NowPlayingPresenterImpl
import id.firman.movies.movie.popular.PopularPresenter
import id.firman.movies.movie.popular.PopularPresenterImpl
import id.firman.movies.movie.upcoming.UpcomingPresenter
import id.firman.movies.movie.upcoming.UpcomingPresenterImpl

@Module
class MovieModule {
    @Provides
    fun provideMainPresenter(movieInteractor: MovieInteractor): NowPlayingPresenter {
        return NowPlayingPresenterImpl(movieInteractor, null)
    }

    @Provides
    @AppScope
    fun provideMainInteractor(api : MovieApi): MovieInteractor {
        return MovieInteractorImpl(api)
    }

    @Provides
    fun provideUpcomingPresenter(movieInteractor: MovieInteractor): UpcomingPresenter {
        return UpcomingPresenterImpl(movieInteractor, null)
    }

    @Provides
    fun providePopularPresenter(movieInteractor: MovieInteractor): PopularPresenter {
        return PopularPresenterImpl(movieInteractor, null)
    }
}