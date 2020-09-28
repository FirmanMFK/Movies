package id.firman.movies.api

import dagger.Module
import dagger.Provides
import id.firman.movies.BuildConfig
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton


@Module
class ApiModule {

    @Provides
    @Singleton
    @Named("baseUrl")
    fun provideBaseUrl(): String {
        return BuildConfig.BASE_URL
    }

    @Provides @Singleton
    fun provideMovieDbApi(retrofit: Retrofit): MovieApi {
        return retrofit.create(MovieApi::class.java)
    }
}