package id.firman.movies.detail

import dagger.Subcomponent
import id.firman.movies.di.AppScope

@AppScope
@Subcomponent(modules = [(DetailModule::class)])
interface DetailComponent {
    fun inject(target: DetailActivity)
}