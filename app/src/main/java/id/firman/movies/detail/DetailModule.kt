package id.firman.movies.detail

import dagger.Module
import dagger.Provides
import id.firman.movies.api.MovieApi
import id.firman.movies.di.AppScope

@Module
class DetailModule {
    @Provides
    fun provideDetailPresenter(detailInteractor: DetailInteractor): DetailPresenter{
        return DetailPresenterImpl(detailInteractor, null)
    }

    @Provides
    @AppScope
    fun provideDetailInteractor(api : MovieApi): DetailInteractor{
        return DetailInteractorImpl(api)
    }
}