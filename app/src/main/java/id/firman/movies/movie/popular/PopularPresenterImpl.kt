package id.firman.movies.movie.popular

import android.util.Log
import id.firman.movies.api.MovieResponse
import id.firman.movies.movie.MovieInteractor
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class PopularPresenterImpl (private val interactor: MovieInteractor, private var view: PopularView?): PopularPresenter {
    override fun setView(popularView: PopularView) {
        view = popularView
        getPopularMovies()
    }

    private fun getPopularMovies() {
        interactor.getPopularMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { popularMoviesResponse -> onGetPopularMoviesSuccess(popularMoviesResponse)},
                { e -> onGetNowPlayingMoviesFailure(e) }
            )
    }

    private fun onGetNowPlayingMoviesFailure(e: Throwable?) {
        Log.e(e?.message, e?.stackTrace.toString())
    }

    private fun onGetPopularMoviesSuccess(popularMoviesResponse: MovieResponse?) {
        view?.showPopularMovies(popularMoviesResponse?.movies)
    }
}